package com.example.demo.api;

import com.example.demo.api.entities.BudgetBreakdown;
import com.example.demo.domain.Country;
import com.example.demo.services.CountryService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@WebMvcTest(CountryController.class)
class CountryControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CountryService countryService;

    @Test
    void fetchAllCountries() throws Exception {
        List<String> borders = List.of("TR","RO","GR","SER","MCD");
        List<String> currency = List.of("BGN");
        Country country = new Country("Bulgaria", "BGR", borders, currency);
        List<Country> countries = List.of(country);
        Mockito.doReturn(countries).when(countryService).getAllCountries();

        mvc.perform(MockMvcRequestBuilders.get("/api/v1/countries")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", is(country.getName())));
    }

    @Test
    void calculateBudget() throws Exception {
            BigDecimal unspentBudget = BigDecimal.valueOf(200);
            BigInteger numberOfRoundTrips =  BigInteger.valueOf(2);
            Map<String,BigDecimal> exchangesRequired = new HashMap<>();
            exchangesRequired.put("Greece",BigDecimal.valueOf(200.00));
            exchangesRequired.put("Romania",BigDecimal.valueOf(973.47));
            exchangesRequired.put("Turkey",BigDecimal.valueOf(2024.59));
            exchangesRequired.put("Republic of Macedonia",BigDecimal.valueOf(12336.93));
            exchangesRequired.put("Serbia",BigDecimal.valueOf(23516.06));
            BudgetBreakdown budgetBreakdown = new BudgetBreakdown(unspentBudget,numberOfRoundTrips, exchangesRequired);

            Mockito.doReturn(budgetBreakdown).when(countryService).calculateBudget("Bulgaria",BigDecimal.valueOf(100),BigDecimal.valueOf(1200),"EUR");

            mvc.perform(MockMvcRequestBuilders.get("/api/v1/countries/calculateBudget")
                    .contentType(MediaType.APPLICATION_JSON)
                    .param("startingCountry", "Bulgaria")
                    .param("budgetPerCountry", "100")
                    .param("totalBudget", "1200")
                    .param("currency", "EUR"))
                    .andExpect(MockMvcResultMatchers.status().isOk());
    }
}