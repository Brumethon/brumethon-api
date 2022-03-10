package com.brumethon.app.infrastructure.database.problemstatus;

import javax.persistence.*;

@Table(name = "problem_status")
@Entity
public class ProblemStatusDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public ProblemStatusDB() {
    }
}
