package com.brumethon.app.expostion.problemstatus.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProblemStatusDTO {

    @NotNull
    public Long id;

    @NotBlank
    public String name;

    public ProblemStatusDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
