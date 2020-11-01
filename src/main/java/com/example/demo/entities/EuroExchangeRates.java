package com.example.demo.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="euroExchangeRates")
public class EuroExchangeRates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String currencyExchangePair;
    private long value;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "currency_pair", unique = true, nullable = false)
    public String getCurrencyExchangePair() {
        return currencyExchangePair;
    }

    public void setCurrencyExchangePair(String currencyExchangePair) {
        this.currencyExchangePair = currencyExchangePair;
    }

    @Column(name = "value", unique = true, nullable = false)
    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
