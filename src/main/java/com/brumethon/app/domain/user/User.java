package com.brumethon.app.domain.user;

import com.brumethon.kernel.Entity;
import com.brumethon.kernel.email.EmailAddress;

public class User extends Entity<Integer> {

    private final String firstName;

    private final String lastName;

    private final String password;

    private final EmailAddress emailAddress;

    public User(Integer id, EmailAddress emailAddress, String firstName, String lastName, String password) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.emailAddress = emailAddress;
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
}
