package com.brumethon.app.infrastructure.database.request;

import com.brumethon.app.infrastructure.database.user.User;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Table(schema = "referent_request")
@Entity
public class ReferentRequest {
    @Id
    private long id;
    @OneToOne
    private User user;
    @OneToOne
    private ReferentRequest status;
    private LocalDate date;
}
