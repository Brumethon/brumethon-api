package com.brumethon.app.domain.problem;

import com.brumethon.app.domain.categories.Categories;
import com.brumethon.app.domain.problemestatus.ProblemStatus;
import com.brumethon.app.domain.scooter.Scooter;
import com.brumethon.kernel.Entity;
import com.brumethon.kernel.coordinate.Coordinate;

import java.time.LocalDate;

public class Problem extends Entity<Long> {

    private final String name;
    private final String description;
    private final Scooter scooter;
    private final Coordinate coordinate;
    private final LocalDate date;
    private final Categories categories;
    private final ProblemStatus status;

    public Problem(Long id, String name, String description, Scooter scooter, Coordinate coordinate, LocalDate date, Categories categories, ProblemStatus status) {
        super(id);
        this.name = name;
        this.description = description;
        this.scooter = scooter;
        this.coordinate = coordinate;
        this.date = date;
        this.categories = categories;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public LocalDate getDate() {
        return date;
    }

    public Categories getCategories() {
        return categories;
    }

    public ProblemStatus getStatus() {
        return status;
    }

    public Scooter getScooter() {
        return scooter;
    }
}
