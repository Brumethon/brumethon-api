package com.brumethon.app.infrastructure.database.problems;

import com.brumethon.app.infrastructure.database.scooter.Scooter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Problems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    @OneToOne(fetch = FetchType.LAZY)
    private Scooter scooter;
    @OneToOne(fetch = FetchType.LAZY)
    private Categories categories;
    @OneToOne(fetch = FetchType.LAZY)
    private ProblemStatus status;
    private String name;
    private String description;
    private Double latitude;
    private Double longitude;

    public Problems() {
    }

    public Problems(LocalDate date, Scooter scooter, Categories categories, ProblemStatus status, String name, String description, Double latitude, Double longitude) {
        this.date = date;
        this.scooter = scooter;
        this.categories = categories;
        this.status = status;
        this.name = name;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
