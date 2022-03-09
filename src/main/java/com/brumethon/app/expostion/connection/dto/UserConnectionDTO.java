package com.brumethon.app.expostion.connection.dto;

import javax.validation.constraints.NotBlank;

public class UserConnectionDTO {
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
