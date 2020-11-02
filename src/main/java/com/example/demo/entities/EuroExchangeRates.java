package com.example.demo.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="euroExchangeRates")
public class EuroExchangeRates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String currencyExchangePair;


    private Double value;







//    @OneToOne(mappedBy = "euroExchangeRates")
//    private Country country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "currency_pair", unique = true, nullable = false)
    public String getCurrencyExchangePair() {
        return currencyExchangePair;
    }

    public void setCurrencyExchangePair(String currencyExchangePair) {
        this.currencyExchangePair = currencyExchangePair;
    }

    @Column(name = "value", unique = true, nullable = false, precision = 2)
    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
