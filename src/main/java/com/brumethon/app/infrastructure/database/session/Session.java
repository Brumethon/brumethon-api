package com.brumethon.app.infrastructure.database.session;

import com.brumethon.app.infrastructure.database.user.User;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tokenId;
    @OneToOne(fetch = FetchType.LAZY)
    private User user;
    private LocalDate expirationDate;

    protected Session() {
    }

    protected Session(User user, LocalDate expirationDate) {
        this.user = user;
        this.expirationDate = expirationDate;
    }
}
