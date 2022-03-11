package com.brumethon.app.expostion.user.dto;

import javax.validation.constraints.NotBlank;

public class UserDTO {

    @NotBlank
    public String email;
    @NotBlank
    public String lastname;
    @NotBlank
    public String firstname;
    @NotBlank
    public String Address;
    @NotBlank
    public String phoneNumber;


    public UserDTO(String email, String lastname, String firstname, String address, String phoneNumber) {
        this.email = email;
        this.lastname = lastname;
        this.firstname = firstname;
        this.Address = address;
        this.phoneNumber = phoneNumber;
    }
}
