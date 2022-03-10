package com.brumethon.app.expostion.user.dto;

import javax.validation.constraints.NotBlank;

public class UserDTO {

    @NotBlank
    private String email;
    @NotBlank
    private String lastname;
    @NotBlank
    private String firstname;
    @NotBlank
    private String Address;

}
