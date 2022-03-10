package com.brumethon.app.infrastructure.database.problems;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "problem_status")
@Entity
public class ProblemStatusDB {
    @Id
    private String name;

    public ProblemStatusDB() {
    }
}
