package com.example.demo.utilities;

import com.example.demo.domain.Country;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountryFileReader {

    private final String REGEX_SPLITTER = "(?![^)(]*\\([^)(]*?\\)\\)),(?![^\\[]*\\])";

    public List<Country> getAllCountriesFromFIle() throws IOException {
        File file = new File("src/test/resources/countries.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        List<Country> countries = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null){
            Country country = new Country();
            String[] strCountry = line.split(REGEX_SPLITTER);
            country.setName(strCountry[0]);
            country.setAlpha3Code(strCountry[1]);
            country.setBorders(Arrays.asList(strCountry[2].replace("[","").replace("]","").split(",")));
            country.setCurrencies(Arrays.asList(strCountry[3].replace("[","").replace(")","").replace("]","").split(",")));
            countries.add(country);
        }
     return countries;
    }
}
