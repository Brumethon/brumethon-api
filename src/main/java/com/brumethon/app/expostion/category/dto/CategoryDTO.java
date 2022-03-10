package com.brumethon.app.expostion.category.dto;

import javax.validation.constraints.NotBlank;

public class CategoryDTO {
    @NotBlank
    public String name;

    public CategoryDTO(String name) {
        this.name = name;
    }
}
