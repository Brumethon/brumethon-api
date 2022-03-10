package com.brumethon.app.infrastructure.database.referent;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Referent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
