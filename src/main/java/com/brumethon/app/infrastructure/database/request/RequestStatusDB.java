package com.brumethon.app.infrastructure.database.request;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "request_status")
@Entity
public class RequestStatusDB {
    @Id
    private String name;
}
