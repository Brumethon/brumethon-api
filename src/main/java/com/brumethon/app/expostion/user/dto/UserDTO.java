package com.brumethon.app.expostion.user.dto;

import com.brumethon.app.domain.user.User;

import javax.validation.constraints.NotBlank;

public class UserDTO {

    @NotBlank
    public String email;
    @NotBlank
    public String lastname;
    @NotBlank
    public String firstname;
    @NotBlank
    public String address;
    @NotBlank
    public String phoneNumber;


    public UserDTO(String email, String lastname, String firstname, String address, String phoneNumber) {
        this.email = email;
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public static UserDTO of(User user) {
        return new UserDTO(
                user.getEmailAddress().toString(),
                user.getLastName(),
                user.getFirstName(),
                user.getAddress().toString(),
                user.getPhoneNumber());
    }
}
