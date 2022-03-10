package com.brumethon.app.domain.scooter;

import com.brumethon.app.domain.scootermodel.ScooterModel;
import com.brumethon.kernel.Entity;

import java.time.LocalDate;

public class Scooter extends Entity<String> {

    private final ScooterModel model;

    private final LocalDate purchaseDate;

    public Scooter(String serialId, ScooterModel model, LocalDate purchaseDate) {
        super(serialId);
        this.model = model;
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
}
