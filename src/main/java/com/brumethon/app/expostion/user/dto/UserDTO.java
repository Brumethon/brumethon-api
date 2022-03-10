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
}
