package com.brumethon.app.infrastructure.database.request;

import com.brumethon.app.infrastructure.database.user.UserDB;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Table(schema = "referent_request")
@Entity
public class ReferentRequestDB {
    @Id
    private long id;
    @OneToOne
    private UserDB userDB;
    @OneToOne
    private ReferentRequestDB status;
    private LocalDate date;
}
