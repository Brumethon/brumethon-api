package com.brumethon.app.infrastructure.database.request;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(schema = "request_status")
@Entity
public class RequestStatus {
    @Id
    private String name;
}
