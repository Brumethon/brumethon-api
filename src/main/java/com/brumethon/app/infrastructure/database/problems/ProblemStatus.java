package com.brumethon.app.infrastructure.database.problems;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(schema = "problem_status")
@Entity
public class ProblemStatus {
    @Id
    private String name;

    public ProblemStatus() {
    }
}
