package com.brumethon.app.expostion.scooter.dto;

import com.brumethon.app.expostion.user.dto.UserDTO;

public class ScooterDTO {
    public Long id;
    public Long scooterModelID;
    public String serialNumber;

    public ScooterDTO(Long id, Long scooterModelID, String serialNumber) {
        this.id = id;
        this.scooterModelID = scooterModelID;
        this.serialNumber = serialNumber;
    }
}
