package com.example.demo.clients.country;

import com.example.demo.domain.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CountryClient {
    private final RestTemplate restTemplate;

    public List<Country> getCountries() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-rapidapi-key", "c1e7fe907cmshda42ec1f1f8b001p1255f2jsn0c0bd54f19ac");
        headers.add("x-rapidapi-host", "ajayakv-rest-countries-v1.p.rapidapi.com");
        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<Country[]> exchange = restTemplate.exchange("https://ajayakv-rest-countries-v1.p.rapidapi.com/rest/v1/all", HttpMethod.GET, entity, Country[].class);
        return Optional.ofNullable(exchange.getBody()).map(Arrays::asList).orElseThrow(() -> new RuntimeException("asd"));
    }
}
