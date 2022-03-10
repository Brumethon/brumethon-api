package com.brumethon.app.domain.session;

import com.brumethon.app.domain.user.User;
import com.brumethon.kernel.Entity;

import java.time.LocalDate;

public class Session extends Entity<Long> {

    private final User user;
    private final LocalDate expirationDate;

    public Session(Long id, User user, LocalDate expirationDate) {
        super(id);
        this.user = user;
        this.expirationDate = expirationDate;
    }

    public Session(User user, LocalDate expirationDate) {
        super(null);
        this.user = user;
        this.expirationDate = expirationDate;
    }
}
