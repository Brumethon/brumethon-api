package com.brumethon.app.infrastructure.database.problemstatus;

import com.brumethon.app.domain.problemestatus.ProblemStatus;

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

    public ProblemStatusDB(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static ProblemStatusDB of(ProblemStatus problemStatus){
        return new ProblemStatusDB(problemStatus.getID(), problemStatus.getName());
    }

    public ProblemStatus toProblemStatus(){
        return new ProblemStatus(id, name);
    }
}
