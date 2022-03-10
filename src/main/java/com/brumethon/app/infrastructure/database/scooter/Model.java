package com.brumethon.app.infrastructure.database.scooter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Model {
    @Id
    private String name;
}
