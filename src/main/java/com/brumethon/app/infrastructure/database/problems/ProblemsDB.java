package com.brumethon.app.infrastructure.database.problems;

import com.brumethon.app.domain.categories.Categories;
import com.brumethon.app.domain.problem.Problem;
import com.brumethon.app.domain.problemestatus.ProblemStatus;
import com.brumethon.app.domain.scooter.Scooter;
import com.brumethon.app.domain.user.User;
import com.brumethon.app.infrastructure.database.categories.CategoriesDB;
import com.brumethon.app.infrastructure.database.problemstatus.ProblemStatusDB;
import com.brumethon.app.infrastructure.database.scooter.ScooterDB;
import com.brumethon.app.infrastructure.database.user.UserDB;
import com.brumethon.kernel.coordinate.Coordinate;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "problems")
@Entity
public class ProblemsDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "problem_id")
    private Long problemID;

    private LocalDate date;

    @OneToOne(fetch = FetchType.EAGER)
    private ScooterDB scooter;

    @OneToOne(fetch = FetchType.EAGER)
    private CategoriesDB categories;

    @OneToOne(fetch = FetchType.EAGER)
    private ProblemStatusDB status;

    private String name;

    private String description;

    @OneToOne(fetch = FetchType.EAGER)
    private UserDB referent;

    private Double latitude;

    private Double longitude;

    public ProblemsDB() {
    }

    public ProblemsDB(Long problemID, LocalDate date, ScooterDB scooter, CategoriesDB categories, ProblemStatusDB status, String name, String description, UserDB referent, Double latitude, Double longitude) {
        this.problemID = problemID;
        this.date = date;
        this.scooter = scooter;
        this.categories = categories;
        this.status = status;
        this.name = name;
        this.description = description;
        this.referent = referent;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public ProblemsDB(LocalDate date, ScooterDB scooter, CategoriesDB categories, ProblemStatusDB status, String name, String description, UserDB referent, Double latitude, Double longitude) {
        this(null, date, scooter, categories, status, name, description, referent, latitude, longitude);
    }

    public Long getId() {
        return problemID;
    }

    public LocalDate getDate() {
        return date;
    }

    public ScooterDB getScooter() {
        return scooter;
    }

    public CategoriesDB getCategories() {
        return categories;
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

    public UserDB getReferent() {
        return referent;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public static ProblemsDB of(Problem problem) {
        return new ProblemsDB(
                problem.getID(),
                problem.getDate(),
                ScooterDB.of(problem.getScooter()),
                CategoriesDB.of(problem.getCategories()),
                ProblemStatusDB.of(problem.getStatus()),
                problem.getName(),
                problem.getDescription(),
                UserDB.of(problem.getReferent()),
                problem.getCoordinate().getLatitude(),
                problem.getCoordinate().getLongitude());
    }

    public Problem toProblem(){
        return new Problem( referent == null ? null : referent.toUser(),
                problemID,
                name,
                description,
                scooter.toScooter(),
                new Coordinate(latitude,longitude), date, categories.toCategories(), status.toProblemStatus());
    }



}
