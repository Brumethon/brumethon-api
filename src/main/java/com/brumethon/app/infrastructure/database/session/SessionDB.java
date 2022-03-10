package com.brumethon.app.infrastructure.database.session;

import com.brumethon.app.domain.session.Session;
import com.brumethon.app.infrastructure.database.user.UserDB;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "session")
@Entity
public class SessionDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String tokenId;

    @OneToOne(fetch = FetchType.LAZY)
    private UserDB userDB;

    private LocalDate expirationDate;

    protected SessionDB() {
    }

    public SessionDB(String tokenId, UserDB userDB, LocalDate expirationDate) {
        this.tokenId = tokenId;
        this.userDB = userDB;
        this.expirationDate = expirationDate;
    }

    protected SessionDB(UserDB userDB, LocalDate expirationDate) {
        this.userDB = userDB;
        this.expirationDate = expirationDate;
    }

    public String getTokenId() {
        return tokenId;
    }

    public UserDB getUserDB() {
        return userDB;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public static SessionDB of(Session session){
        return new SessionDB(session.getTokenID(), UserDB.of(session.getUser()), session.getExpirationDate());
    }

    public Session toSession(){
        return new Session(tokenId, userDB.toUser(), expirationDate);
    }

}
