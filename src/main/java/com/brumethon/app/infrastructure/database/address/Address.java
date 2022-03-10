package com.brumethon.app.infrastructure.database.address;

import javax.persistence.*;

@Table(schema = "address")
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String street;
    private String number;
    private String country;
    private String postalCode;
    private Double latitude;
    private Double longitude;

    protected Address() {
    }

    protected Address(String city, String street, String number, String country, String postalCode, Double latitude, Double longitude) {
        this.city = city;
        this.street = street;
        this.number = number;
        this.country = country;
        this.postalCode = postalCode;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
