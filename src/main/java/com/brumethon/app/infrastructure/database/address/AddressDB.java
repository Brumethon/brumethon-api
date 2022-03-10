package com.brumethon.app.infrastructure.database.address;

import com.brumethon.app.domain.address.Address;

import javax.persistence.*;

@Table(name = "address")
@Entity
public class AddressDB {
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

    protected AddressDB() {
    }

    protected AddressDB(String city, String street, String number, String country, String postalCode, Double latitude, Double longitude) {
        this.city = city;
        this.street = street;
        this.number = number;
        this.country = country;
        this.postalCode = postalCode;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public static AddressDB of(Address address) {
        return new AddressDB(
                address.getCity(),
                address.getStreet(),
                address.getNumber(),
                address.getCountry(),
                address.getPostalCode(),
                address.getLatitude(),
                address.getLongitude());
    }

    public Long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getCountry() {
        return country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
}
