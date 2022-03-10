package com.brumethon.app.infrastructure.database.request;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RequestStatus {
    @Id
    private String name;
}
