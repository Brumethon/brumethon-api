package com.brumethon.app.infrastructure.database.user;

import com.brumethon.app.infrastructure.database.address.Address;
import com.brumethon.app.infrastructure.database.role.Role;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

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
    @ManyToMany
    private Set<Role> role;

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
