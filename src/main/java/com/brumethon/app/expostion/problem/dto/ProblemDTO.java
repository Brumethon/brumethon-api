package com.brumethon.app.expostion.problem.dto;

import com.brumethon.app.expostion.category.dto.CategoryDTO;
import com.brumethon.app.expostion.scooter.dto.ScooterDTO;
import com.brumethon.app.expostion.user.dto.UserDTO;

import java.time.LocalDate;

public class ProblemDTO {

    public Long id;
    public String name;
    public String description;
    public ScooterDTO scooter;
    public Double latitude;
    public Double longitude;
    public LocalDate date;
    public UserDTO owner;
    public UserDTO referent;
    public CategoryDTO category;

    public ProblemDTO(Long id, String name, String description, ScooterDTO scooterDTO, Double latitude, Double longitude, LocalDate date, UserDTO owner, UserDTO referent, CategoryDTO categoryDTO) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.scooter = scooterDTO;
        this.latitude = latitude;
        this.longitude = longitude;
        this.date = date;
        this.owner = owner;
        this.referent = referent;
        this.category = categoryDTO;
    }
}
