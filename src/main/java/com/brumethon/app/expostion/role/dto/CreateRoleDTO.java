package com.brumethon.app.expostion.role.dto;

import javax.validation.constraints.NotBlank;

public class CreateRoleDTO {

    @NotBlank
    public String name;



    public CreateRoleDTO(String name) {
        this.name = name;
    }
}
