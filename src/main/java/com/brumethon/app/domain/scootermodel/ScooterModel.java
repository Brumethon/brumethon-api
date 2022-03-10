package com.brumethon.app.domain.scootermodel;

import com.brumethon.kernel.Entity;

public class ScooterModel extends Entity<Long> {

    private final String name;

    public ScooterModel(Long id, String name) {
        super(id);
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
