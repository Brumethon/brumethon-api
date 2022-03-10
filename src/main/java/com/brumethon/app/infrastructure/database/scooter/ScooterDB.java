package com.brumethon.app.infrastructure.database.scooter;

import com.brumethon.app.domain.scooter.Scooter;
import com.brumethon.app.infrastructure.database.scootermodel.ScooterModelDB;
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
    private ScooterModelDB scooterModelDB;
    @OneToOne(fetch = FetchType.LAZY)
    private UserDB userDB;

    public ScooterDB() {
    }

    public ScooterDB(Long id, LocalDate dateOfPurchase, ScooterModelDB scooterModelDB, UserDB userDB) {
        this.id = id;
        this.dateOfPurchase = dateOfPurchase;
        this.scooterModelDB = scooterModelDB;
        this.userDB = userDB;
    }

    public ScooterDB(LocalDate dateOfPurchase, ScooterModelDB scooterModelDB) {
        this.dateOfPurchase = dateOfPurchase;
        this.scooterModelDB = scooterModelDB;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public ScooterModelDB getScooterModelDB() {
        return scooterModelDB;
    }

    public UserDB getUserDB() {
        return userDB;
    }

    public static ScooterDB of(Scooter scooter){
        return null;
    }

}
