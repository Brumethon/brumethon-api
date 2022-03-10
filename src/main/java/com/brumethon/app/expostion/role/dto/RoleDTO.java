package com.brumethon.app.expostion.role.dto;

import javax.validation.constraints.NotBlank;

public class RoleDTO {

    @NotBlank
    public String name;

    public RoleDTO(String name) {
        this.name = name;
    }
}
