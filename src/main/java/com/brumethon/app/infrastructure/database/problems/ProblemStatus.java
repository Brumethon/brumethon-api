package com.brumethon.app.infrastructure.database.problems;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProblemStatus {
    @Id
    private String name;

    public ProblemStatus() {
    }
}
