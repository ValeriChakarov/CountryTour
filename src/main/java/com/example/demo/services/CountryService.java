package com.example.demo.services;

import com.example.demo.api.entities.BudgetBreakdown;
import com.example.demo.clients.country.CountryClient;
import com.example.demo.clients.rates.ExchangeRateClient;
import com.example.demo.domain.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryClient countryClient;

    private final ExchangeRateClient exchangeRateClient;

    public List<Country> getAllCountries() {

        return countryClient.getCountries();
    }

    public Optional<Country> getCountryByName(String name) {
        return getCountryByName(getAllCountries(), name);
    }

    public BudgetBreakdown calculateBudget(@RequestParam String startingCountry, BigDecimal budgetPerCountry, BigDecimal totalBudget, String currency) {
        List<Country> allCountries = getAllCountries();
        Country country = getCountryByName(allCountries, startingCountry).orElseThrow(() -> new RuntimeException("Country name cannot be found."));
        List<Country> neighbouringCountries =
                allCountries
                        .stream()
                        .filter(c -> country.getBorders().contains(c.getAlpha3Code()))
                        .collect(Collectors.toList());
        BigDecimal budgetPerRoundTrip = budgetPerCountry.multiply(BigDecimal.valueOf(neighbouringCountries.size()));
        BigDecimal remainder = totalBudget.remainder(budgetPerRoundTrip);
        BigInteger tripCount = totalBudget.divide(budgetPerRoundTrip, RoundingMode.FLOOR).toBigInteger();
        BigDecimal tripBudget = budgetPerCountry.multiply(new BigDecimal(tripCount));
        Map<String, BigDecimal> rates = neighbouringCountries.stream()
                .collect(Collectors.toMap(
                        Country::getName,
                        neighbourCountry -> exchangeRateClient.getExchangeRate(
                                currency,
                                neighbourCountry.getCurrencies().get(0)).multiply(tripBudget).setScale(2, RoundingMode.HALF_UP)));

        return new BudgetBreakdown(remainder, tripCount, rates);
    }

    private Optional<Country> getCountryByName(List<Country> countries, String name) {
        return countries
                .stream()
                .filter(x -> x.getName().equals(name))
                .findAny();
    }
}


