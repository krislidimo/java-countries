package com.lambdaschool.javacountries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavacountriesApplication {

    public static CountryList countries;
    public static void main(String[] args) {
        countries = new CountryList();
        SpringApplication.run(JavacountriesApplication.class, args); }

}
