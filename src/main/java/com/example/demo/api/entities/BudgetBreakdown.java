package com.example.demo.api.entities;

import lombok.Value;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;

@Value
public class BudgetBreakdown {

    BigDecimal unspentBudget;
    BigInteger numberOfRoundTrips;
    Map<String, BigDecimal> exchangesRequired;
}
