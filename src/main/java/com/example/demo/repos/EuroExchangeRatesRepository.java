package com.example.demo.repos;

import com.example.demo.entities.Country;
import com.example.demo.entities.EuroExchangeRates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import static javax.persistence.criteria.JoinType.INNER;
import static org.hibernate.FetchMode.JOIN;
import static org.hibernate.hql.internal.antlr.SqlTokenTypes.ON;
import static org.hibernate.loader.Loader.SELECT;
import static org.springframework.http.HttpHeaders.FROM;

@Repository
public interface EuroExchangeRatesRepository
        extends CrudRepository<EuroExchangeRates, Long> {

    EuroExchangeRates findById(int id);
    List<EuroExchangeRates> findAll();
    void deleteById(int id);

    @Query(value = "SELECT e FROM EuroExchangeRates e WHERE e.currencyExchangePair != ?1")
    List<EuroExchangeRates> getCountryBudgets(String currencyExchangePair);


}
