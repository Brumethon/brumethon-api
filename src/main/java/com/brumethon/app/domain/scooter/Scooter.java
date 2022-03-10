package com.brumethon.app.domain.scooter;

import com.brumethon.app.domain.scootermodel.ScooterModel;
import com.brumethon.app.domain.user.User;
import com.brumethon.kernel.Entity;

import java.time.LocalDate;

public class Scooter extends Entity<String> {

    private final ScooterModel model;

    private final User owner;

    private final LocalDate purchaseDate;

    public Scooter(String serialId, ScooterModel model, User owner, LocalDate purchaseDate) {
        super(serialId);
        this.model = model;
        this.owner = owner;
        this.purchaseDate = purchaseDate;
    }

    public String getSerialID(){
        return id;
    }

    public ScooterModel getModel() {
        return model;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public User getOwner() {
        return owner;
    }
}
