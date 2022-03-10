package com.brumethon.app.expostion.problem.dto;

import com.brumethon.app.domain.categories.Categories;
import com.brumethon.app.domain.problemestatus.ProblemStatus;
import com.brumethon.app.domain.scooter.Scooter;
import com.brumethon.app.expostion.category.dto.CategoryDTO;
import com.brumethon.app.expostion.problemstatus.dto.ProblemStatusDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class CreateProblemDTO {
    @NotBlank
    public String name;
    @NotBlank
    public String description;
    public Long scooterId;
    public Double latitude;
    public Double longitude;
    public Long categoryId;
    public Long problemStatusId;
}
