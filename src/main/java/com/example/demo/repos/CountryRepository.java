package com.example.demo.repos;

import com.example.demo.entities.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository
        extends CrudRepository<Country,
                Integer> {

    Country findById(int id);
    List<Country> findAll();
    void deleteById(int id);
}
