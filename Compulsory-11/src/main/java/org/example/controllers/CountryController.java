package org.example.controllers;

import entities.Country;
import repositories.CountryRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.List;

@RestController
public class CountryController {

    private final CountryRepository countryRepository;

    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

//    @GetMapping("/api/countries" )
    @GetMapping(value = "/api/countries", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Country> getCountriesAtRoot() {
        return countryRepository.findAll();
    }
}
