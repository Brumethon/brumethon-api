package com.brumethon.app.infrastructure.database.scooter;

import com.brumethon.app.infrastructure.database.user.User;

import javax.persistence.*;
import java.time.LocalDate;

@Table(schema = "scooter")
@Entity
public class Scooter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateOfPurchase;
    @OneToOne
    private Model model;
    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    public Scooter() {
    }

    public Scooter(LocalDate dateOfPurchase, Model model) {
        this.dateOfPurchase = dateOfPurchase;
        this.model = model;
    }
}
