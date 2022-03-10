package com.brumethon.app.infrastructure.database.problems;

import com.brumethon.app.infrastructure.database.referent.ReferentDB;
import com.brumethon.app.infrastructure.database.scooter.ScooterDB;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "problems")
@Entity
public class ProblemsDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    @OneToOne(fetch = FetchType.LAZY)
    private ScooterDB scooterDB;
    @OneToOne(fetch = FetchType.LAZY)
    private CategoriesDB categoriesDB;
    @OneToOne(fetch = FetchType.LAZY)
    private ProblemStatusDB status;
    private String name;
    private String description;
    @OneToOne(fetch = FetchType.LAZY)
    private ReferentDB referentDB;
    private Double latitude;
    private Double longitude;

    public ProblemsDB() {
    }

    public ProblemsDB(LocalDate date, ScooterDB scooterDB, CategoriesDB categoriesDB, ProblemStatusDB status, String name, String description, ReferentDB referentDB, Double latitude, Double longitude) {
        this.date = date;
        this.scooterDB = scooterDB;
        this.categoriesDB = categoriesDB;
        this.status = status;
        this.name = name;
        this.description = description;
        this.referentDB = referentDB;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
