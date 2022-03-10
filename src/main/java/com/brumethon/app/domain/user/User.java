package com.brumethon.app.domain.user;

import com.brumethon.app.domain.address.Address;
import com.brumethon.kernel.Entity;
import com.brumethon.kernel.email.EmailAddress;

public class User extends Entity<Long> {

    private final String firstName;
    private final String lastName;
    private final String password;
    private final String phoneNumber;
    private final EmailAddress emailAddress;
    private final Address address;

    public User(Long id, EmailAddress emailAddress, String firstName, String lastName, String password, String phoneNumber, Address address) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.address = address;
    }

    public User(String firstName, String lastName, String password, String phoneNumber, EmailAddress emailAddress, Address address) {
        super(null);
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.address = address;
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
}
