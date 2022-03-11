package com.brumethon.app.domain.user;

import com.brumethon.app.domain.address.Address;
import com.brumethon.app.domain.categories.Categories;
import com.brumethon.kernel.Entity;
import com.brumethon.kernel.email.EmailAddress;

import java.util.ArrayList;
import java.util.List;

public class User extends Entity<Long> {

    private final String firstName;
    private final String lastName;
    private final String password;
    private final String phoneNumber;
    private final EmailAddress emailAddress;
    private final Address address;

    private final List<Categories> categories;

    public User(Long id,
                String firstName, String lastName,
                String password,
                String phoneNumber,
                EmailAddress emailAddress,
                Address address,
                List<Categories> categories) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.address = address;
        this.categories = categories;
    }

    public User(Long id, String firstName, String lastName, String password, String phoneNumber, EmailAddress emailAddress, Address address) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.address = address;
        categories = new ArrayList<>();
    }

    public User(String firstName, String lastName, String password, String phoneNumber, EmailAddress emailAddress, Address address) {
        super(null);
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.address = address;
        categories = new ArrayList<>();
    }



    public EmailAddress getEmailAddress() {
        return emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public List<Categories> getCategories() {
        return categories;
    }
}
