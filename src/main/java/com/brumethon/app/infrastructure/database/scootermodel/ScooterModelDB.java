package com.brumethon.app.infrastructure.database.scootermodel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "model")
@Entity
public class ScooterModelDB {
    @Id
    private String name;
}
