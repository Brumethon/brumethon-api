package com.brumethon.app.infrastructure.database.scooter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "model")
@Entity
public class ModelDB {
    @Id
    private String name;
}
