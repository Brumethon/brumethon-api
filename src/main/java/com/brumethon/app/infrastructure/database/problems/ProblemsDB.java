package com.brumethon.app.infrastructure.database.problems;

import com.brumethon.app.domain.problem.Problem;
import com.brumethon.app.infrastructure.database.categories.CategoriesDB;
import com.brumethon.app.infrastructure.database.problemstatus.ProblemStatusDB;
import com.brumethon.app.infrastructure.database.scooter.ScooterDB;
import com.brumethon.app.infrastructure.database.user.UserDB;

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
    private UserDB referentUser;
    private Double latitude;
    private Double longitude;

    public ProblemsDB() {
    }

    public ProblemsDB(LocalDate date, ScooterDB scooterDB, CategoriesDB categoriesDB, ProblemStatusDB status, String name, String description, UserDB referentUser, Double latitude, Double longitude) {
        this.date = date;
        this.scooterDB = scooterDB;
        this.categoriesDB = categoriesDB;
        this.status = status;
        this.name = name;
        this.description = description;
        this.referentUser = referentUser;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public ScooterDB getScooterDB() {
        return scooterDB;
    }

    public CategoriesDB getCategoriesDB() {
        return categoriesDB;
    }

    public ProblemStatusDB getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public UserDB getReferentUser() {
        return referentUser;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public static ProblemsDB of(Problem problem) {
        return new ProblemsDB(
                problem.getDate(),
                ScooterDB.of(problem.getScooter()),
                CategoriesDB.of(problem.getCategories()),
                ProblemStatusDB.of(problem.getStatus()),
                problem.getName(),
                problem.getDescription(),
                UserDB.of(problem.getScooter().getOwner()),
                problem.getCoordinate().getLatitude(),
                problem.getCoordinate().getLongitude());
    }

    public Problem toProblem(){
        return null;
    }



}
