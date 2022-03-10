package com.brumethon.app.infrastructure.database.referent;

import com.brumethon.app.infrastructure.database.problems.Categories;
import com.brumethon.app.infrastructure.database.user.User;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Referent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    private User user;
    private boolean isOffline;
    @ManyToMany(fetch = FetchType.LAZY)
    Set<Categories> categories;

    public Referent() {
    }

    public Referent(User user, boolean isOffline) {
        this.user = user;
        this.isOffline = isOffline;
    }
}
