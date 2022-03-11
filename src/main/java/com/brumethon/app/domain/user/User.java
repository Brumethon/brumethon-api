package com.brumethon.app.domain.user;

import com.brumethon.app.domain.address.Address;
import com.brumethon.app.domain.categories.Categories;
import com.brumethon.app.domain.role.Role;
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

    private final List<Categories> assignedCategories;

    private final List<Role> assignedRoles;

    public User(Long id,
                String firstName, String lastName,
                String password,
                String phoneNumber,
                EmailAddress emailAddress,
                Address address,
                List<Categories> assignedCategories,
                List<Role> assignedRoles) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.address = address;
        this.assignedCategories = assignedCategories;
        this.assignedRoles = assignedRoles;
    }

    public User(Long id, String firstName, String lastName, String password, String phoneNumber, EmailAddress emailAddress, Address address) {
        this(id, firstName, lastName, password, phoneNumber, emailAddress, address, new ArrayList<>(), new ArrayList<>());
    }

    public User(String firstName, String lastName, String password, String phoneNumber, EmailAddress emailAddress, Address address) {
        this(null, firstName, lastName, password, phoneNumber, emailAddress, address, new ArrayList<>(), new ArrayList<>());
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

    public List<Categories> getAssignedCategories() {
        return assignedCategories;
    }

    public List<Role> getAssignedRoles() {
        return assignedRoles;
    }
}
