package com.brumethon.app.infrastructure.database.scooter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Scooter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateOfPurchase;
    @OneToOne
    private Model model;

    public Scooter() {
    }

    public Scooter(LocalDate dateOfPurchase, Model model) {
        this.dateOfPurchase = dateOfPurchase;
        this.model = model;
    }
}
