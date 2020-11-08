package com.example.demo.services;

import com.example.demo.clients.country.CountryClient;
import com.example.demo.clients.rates.ExchangeRateClient;
import com.example.demo.domain.Country;
import com.example.demo.utilities.CountryFileReader;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountryServiceTest {

    private final CountryClient countryClient = Mockito.mock(CountryClient.class);

    private final ExchangeRateClient exchangeRateClient = Mockito.mock(ExchangeRateClient.class);

    private CountryService countryService;

    private final CountryFileReader countryFileReader;

    public CountryServiceTest() {
        countryService = new CountryService(countryClient,exchangeRateClient);
        countryFileReader = new CountryFileReader();
    }

    @Test
    void getAllCountries() throws IOException {
    }

    @Test
    void getCountryByName() {
    }

    @Test
    void calculateBudget() {
    }
}