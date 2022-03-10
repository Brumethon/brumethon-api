package com.brumethon.app.infrastructure.database.scooter;

import com.brumethon.app.infrastructure.database.user.UserDB;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "scooter")
@Entity
public class ScooterDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateOfPurchase;
    @OneToOne
    private ModelDB modelDB;
    @OneToOne(fetch = FetchType.LAZY)
    private UserDB userDB;

    public ScooterDB() {
    }

    public ScooterDB(LocalDate dateOfPurchase, ModelDB modelDB) {
        this.dateOfPurchase = dateOfPurchase;
        this.modelDB = modelDB;
    }
}
