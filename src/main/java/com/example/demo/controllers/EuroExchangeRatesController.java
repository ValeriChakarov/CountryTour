package com.example.demo.controllers;


import com.example.demo.entities.EuroExchangeRates;
import com.example.demo.repos.CountryRepository;
import com.example.demo.repos.EuroExchangeRatesRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
public class EuroExchangeRatesController {

    @Autowired
    private EuroExchangeRatesRepository euroExcahngeRatesRepo;

    @GetMapping("/country/calculateBudget")
    public String getBduget(){
        List<EuroExchangeRates> stuf = euroExcahngeRatesRepo.getCountryBudgets("EURBGN");
        StringBuffer result = new StringBuffer();
        for (EuroExchangeRates word: stuf) {
            result.append(word.getCurrencyExchangePair() + ":" + word.getValue() + "\n");
        }
        return result.toString();
    }
    //Home Page
    @GetMapping("/currency/getAllCurrencyPairs")
    public List<EuroExchangeRates> getListOfAllCurrencyPairs()
    {
        return euroExcahngeRatesRepo.findAll();
    }

    @PostMapping("/currency/addCurrencyPair")
    public void addCurrencyPair(@RequestBody EuroExchangeRates newEuroExchangeRates){
        euroExcahngeRatesRepo.save(newEuroExchangeRates);
    }

    @Transactional
    @DeleteMapping("/currency/deleteCurrencyPairById")
    public void deleteCountryById(
            @RequestParam int id)
    {
        euroExcahngeRatesRepo.deleteById(id);
    }

    @PostMapping("/currency/modifyCurrency")
    public void updateCurrency(@RequestParam int  id, String euroPair, Double euroPairRate) {
            Optional<EuroExchangeRates> euroPairToFix = Optional.ofNullable(euroExcahngeRatesRepo.findById(id));
            EuroExchangeRates newPair = euroPairToFix.get();
            newPair.setCurrencyExchangePair(euroPair);
            newPair.setValue(euroPairRate);

            euroExcahngeRatesRepo.save(newPair);
    }

}
