package com.brumethon.app.infrastructure.database.scootermodel;

import javax.persistence.*;

@Table(name = "model")
@Entity
public class ScooterModelDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
