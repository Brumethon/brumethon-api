package com.brumethon.app.domain.session;

import com.brumethon.app.domain.user.User;
import com.brumethon.kernel.Entity;

import java.time.LocalDateTime;

public class Session extends Entity<String> {

    private final User user;
    private final LocalDateTime expirationDate;

    public Session(String tokenID, User user, LocalDateTime expirationDate) {
        super(tokenID);
        this.user = user;
        this.expirationDate = expirationDate;
    }

    public Session(User user, LocalDateTime expirationDate) {
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

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }
}
