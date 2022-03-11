package com.brumethon.app.expostion.problem.dto;

import com.brumethon.app.expostion.category.dto.CategoryDTO;
import com.brumethon.app.expostion.scooter.dto.ScooterDTO;
import org.springframework.beans.factory.parsing.Problem;

import java.time.LocalDate;

public class ProblemDTO {

    public Long id;
    public String name;
    public String description;
    public ScooterDTO scooterDTO;
    public Double latitude;
    public Double longitude;
    public LocalDate date;
    public CategoryDTO categoryDTO;

    public ProblemDTO(Long id, String name, String description, ScooterDTO scooterDTO, Double latitude, Double longitude, LocalDate date, CategoryDTO categoryDTO) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.scooterDTO = scooterDTO;
        this.latitude = latitude;
        this.longitude = longitude;
        this.date = date;
        this.categoryDTO = categoryDTO;
    }
}
