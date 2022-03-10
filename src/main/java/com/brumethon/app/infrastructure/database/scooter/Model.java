package com.brumethon.app.infrastructure.database.scooter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(schema = "model")
@Entity
public class Model {
    @Id
    private String name;
}
