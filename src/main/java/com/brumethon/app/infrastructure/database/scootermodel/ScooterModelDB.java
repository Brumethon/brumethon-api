package com.brumethon.app.infrastructure.database.scootermodel;

import com.brumethon.app.domain.scootermodel.ScooterModel;

import javax.persistence.*;

@Table(name = "model")
@Entity
public class ScooterModelDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public ScooterModelDB(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ScooterModelDB() {
    }

     static public ScooterModelDB of(ScooterModel scooterModel){
        return new ScooterModelDB(scooterModel.getID(), scooterModel.getName());
    }

    public ScooterModel toScooterModel(){
        return new ScooterModel(id, name);
    }

}
