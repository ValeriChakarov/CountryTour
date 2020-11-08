package com.example.demo.api;

//import com.example.demo.APIConsumer;

import com.example.demo.api.entities.BudgetBreakdown;
import com.example.demo.domain.Country;
import com.example.demo.services.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

//import com.example.demo.repos.EuroExchangeRatesRepository;

@RestController
@RequestMapping("/api/v1/countries")
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @GetMapping
    public ResponseEntity<List<Country>> fetchAllCountries() {
        return ResponseEntity.ok(countryService.getAllCountries());
    }

    @GetMapping("/calculateBudget")
    public ResponseEntity<BudgetBreakdown> calculateBudget(@RequestParam String startingCountry,
                                                           BigDecimal budgetPerCountry,
                                                           BigDecimal totalBudget,
                                                           String currency) {
        return ResponseEntity.ok(countryService.calculateBudget(startingCountry, budgetPerCountry, totalBudget, currency));
    }
}
