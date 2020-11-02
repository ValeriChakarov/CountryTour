package com.example.demo.controllers;

import com.example.demo.entities.Country;
import com.example.demo.repos.CountryRepository;
import com.example.demo.repos.EuroExchangeRatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
    private CountryRepository countryRepo;

    @Autowired
    private EuroExchangeRatesRepository exchangeRatesRepository;

    //Home Page
    @GetMapping("/")
    public String welcome()
    {
        return "<html><body>"
                + "<h1>WELCOME</h1>"
                + "</body></html>";
    }

    // Get All Notes
    @GetMapping("/getAllCountries")
    public List<Country> getListOfAllCountries()
    {
        return countryRepo.findAll();
    }

    @GetMapping("/getCountryById")
    public Country getCountryById(@RequestParam int id)
    {

        return countryRepo.findById(id);
    }

//    @GetMapping("/country/calculateBudget")
//    @ResponseBody
//    public String getTotalBudget(@RequestParam String startingCountry, String budgetPerCountry, String totalBudget, String currency) {
////        String theFinalString = "Starting Country: " + startingCountry + "\n" +
////                                "Budget per Country:" +  budgetPerCountry + "\n" +
////                                "Total Budget:" + totalBudget + "\n" +
////                                "Currency:" + currency;
//        String theFinalString = "";
//        StringBuffer  theFinalStringBuff = new StringBuffer(theFinalString);
//        int count = 0;
//        while(count < exchangeRatesRepository.count()){
//            theFinalStringBuff.append(exchangeRatesRepository.findAll().get(count).getCurrencyExchangePair() + ":" + exchangeRatesRepository.findAll().get(count).getValue()*Double.valueOf(budgetPerCountry) + "\n");
//            count++;
//        }
//
//        return theFinalStringBuff.toString();
//    }

    @PostMapping("/country/addCountry")
    public Country addCountry(@RequestBody Country newCountry){
        return countryRepo.save(newCountry);

    }

    @DeleteMapping("/country/deleteCountryById")
    public void deleteCountryById(
            @RequestParam int id)
    {
        countryRepo.deleteById(id);
    }

}
