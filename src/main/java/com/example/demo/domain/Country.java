package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country {

    String name;

    String alpha3Code;

    List<String> borders;

    List<String> currencies;

}

