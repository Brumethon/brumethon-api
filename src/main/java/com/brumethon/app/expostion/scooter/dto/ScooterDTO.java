package com.brumethon.app.expostion.scooter.dto;

public class ScooterDTO {
    public long id;
    public long scooterModelID;
    public String serialNumber;

    public ScooterDTO(long id, long scooterModelID, String serialNumber) {
        this.id = id;
        this.scooterModelID = scooterModelID;
        this.serialNumber = serialNumber;
    }
}
