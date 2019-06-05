package com.lambdaschool.javacountries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("")
public class CountryController {

    //localhost:2019/names/all
    @GetMapping(value = "/names/all", produces = {"application/json"})
    public ResponseEntity<?> getAllCountries() {
        return new ResponseEntity<>(JavacountriesApplication.countries.countryList, HttpStatus.OK);
    }

    //localhost:2019/names/start/{letter}
    @GetMapping(value = "/names/start/{letter}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesByLetter(@PathVariable char letter) {
        ArrayList<Country> tempCountries = JavacountriesApplication.countries
                .findCountries(c -> (c.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter)));
        return new ResponseEntity<>(tempCountries, HttpStatus.OK);
    }

    //localhost:2019/names/size/{number}
    @RequestMapping(value = "/names/size/{number}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesByLength(@PathVariable int number) {
        ArrayList<Country> tempCountries = JavacountriesApplication.countries
                .findCountries(c -> c.getName().length() >= number);
        return new ResponseEntity<>(tempCountries, HttpStatus.OK);
    }

    //localhost:2019/population/size/{people}
    @RequestMapping(value = "/population/size/{people}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesByPopulationSize(@PathVariable int people) {
        ArrayList<Country> tempCountries = JavacountriesApplication.countries
                .findCountries(c -> c.getPopulation() >= people);
        return new ResponseEntity<>(tempCountries, HttpStatus.OK);
    }

    //localhost:2019/population/min
    @RequestMapping(value = "/population/min", produces = {"application/json"})
    public ResponseEntity<?> getCountryMinSize() {
        Country tempCountry = JavacountriesApplication.countries.getMin();
        return new ResponseEntity<>(tempCountry, HttpStatus.OK);
    }

    //localhost:2019/population/max
    @RequestMapping(value = "/population/max", produces = {"application/json"})
    public ResponseEntity<?> getCountryMaxSize() {
        Country tempCountry = JavacountriesApplication.countries.getMax();
        return new ResponseEntity<>(tempCountry, HttpStatus.OK);
    }
}
