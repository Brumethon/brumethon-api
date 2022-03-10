package com.brumethon.app.domain.problemestatus;

import com.brumethon.kernel.Entity;

public class ProblemStatus extends Entity<String> {
    public ProblemStatus(String name) {
        super(name);
    }

    public String getName(){
        return id;
    }
}
