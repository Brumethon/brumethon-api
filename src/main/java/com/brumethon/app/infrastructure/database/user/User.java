package com.brumethon.app.infrastructure.database.user;

import com.brumethon.app.infrastructure.database.address.Address;
import com.brumethon.app.infrastructure.database.scooter.Scooter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mail;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate registerDate;
    @OneToOne(fetch = FetchType.LAZY)
    private Address address;

    protected User() {
    }

    protected User(String mail, String password, String firstName, String lastName, LocalDate registerDate, Address address) {
        this.mail = mail;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.registerDate = registerDate;
        this.address = address;
    }
}
