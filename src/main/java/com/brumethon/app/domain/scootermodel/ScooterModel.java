package com.brumethon.app.domain.scootermodel;

import com.brumethon.kernel.Entity;

public class ScooterModel extends Entity<String> {

    public ScooterModel(String name) {
        super(name);
    }

    public String getName(){
        return id;
    }
}
