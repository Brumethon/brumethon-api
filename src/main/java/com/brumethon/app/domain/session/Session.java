package com.brumethon.app.domain.session;

import com.brumethon.app.domain.user.User;
import com.brumethon.kernel.Entity;

import java.time.LocalDate;

public class Session extends Entity<String> {

    private final User user;
    private final LocalDate expirationDate;

    public Session(String tokenID, User user, LocalDate expirationDate) {
        super(tokenID);
        this.user = user;
        this.expirationDate = expirationDate;
    }

    public Session(User user, LocalDate expirationDate) {
        super(null);
        this.user = user;
        this.expirationDate = expirationDate;
    }

    public User getUser() {
        return user;
    }

    public String getTokenID(){
        return id;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }
}
