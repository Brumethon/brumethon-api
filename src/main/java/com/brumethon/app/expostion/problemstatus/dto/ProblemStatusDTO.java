package com.brumethon.app.expostion.problemstatus.dto;

import javax.validation.constraints.NotBlank;

public class ProblemStatusDTO {
    @NotBlank
    public String name;

    public ProblemStatusDTO(String name) {
        this.name = name;
    }
}
