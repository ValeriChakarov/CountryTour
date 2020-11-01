package com.example.demo.repos;

import com.example.demo.entities.Country;
import com.example.demo.entities.EuroExchangeRates;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EuroExchangeRatesRepository
        extends CrudRepository<EuroExchangeRates, Long> {

    EuroExchangeRates findById(int id);
    List<EuroExchangeRates> findAll();
    void deleteById(int id);
}
