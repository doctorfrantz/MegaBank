package com.ironhack.demosecurityjwt.tools;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;

@Embeddable
public class Address {
    /* - street: String;
- city: String;
- zipCode: double;
- country: String;*/
    private String street;
    private String city;
    private double zipCode;
    private String country;

    public Address() {
    }

    public Address(String street, String city, double zipCode, String country) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
    }
}
