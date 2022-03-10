package com.brumethon.app.domain.scootermodel;

import com.brumethon.kernel.Entity;

public class ScooterModel extends Entity<String> {

    private final String description;

    public ScooterModel(String name, String description) {
        super(name);
        this.description = description;
    }

    public String getName(){
        return id;
    }

    public String getDescription() {
        return description;
    }
}
