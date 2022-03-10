package com.brumethon.app.infrastructure.database.session;

import com.brumethon.app.infrastructure.database.user.UserDB;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "session")
@Entity
public class SessionDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tokenId;
    @OneToOne(fetch = FetchType.LAZY)
    private UserDB userDB;
    private LocalDate expirationDate;

    protected SessionDB() {
    }

    protected SessionDB(UserDB userDB, LocalDate expirationDate) {
        this.userDB = userDB;
        this.expirationDate = expirationDate;
    }
}
