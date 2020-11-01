package com.example.demo.controllers;

import com.example.demo.entities.Country;
import com.example.demo.repos.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    //Home Page
    @GetMapping("/")
    public String welcome()
    {
        return "<html><body>"
                + "<h1>WELCOME</h1>"
                + "</body></html>";
    }

    // Get All Notes
    @GetMapping("/country")
    public List<Country> getAllNotes()
    {
        return countryRepo.findAll();
    }

    @GetMapping("/country/calculateBudget")
    @ResponseBody
    public String getTotalBudget(@RequestParam String startingCountry, String budgetPerCountry, String totalBudget, String currency) {
        String theFinalString = "Starting Country: " + startingCountry + "\n" +
                                "Budget per Country:" +  budgetPerCountry + "\n" +
                                "Total Budget:" + totalBudget + "\n" +
                                "Currency:" + currency;
        return theFinalString;
    }

    @PostMapping("/country/addCountry")
    public Country addCountry(@RequestBody Country newCountry){
        return countryRepo.save(newCountry);

    }}
