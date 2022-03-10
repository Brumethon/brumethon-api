package com.brumethon.app.infrastructure.database.referent;

import com.brumethon.app.infrastructure.database.problems.CategoriesDB;
import com.brumethon.app.infrastructure.database.user.UserDB;

import javax.persistence.*;
import java.util.Set;

@Table(name = "referent")
@Entity
public class ReferentDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    private UserDB userDB;
    private boolean isOffline;
    @ManyToMany(fetch = FetchType.LAZY)
    Set<CategoriesDB> categories;

    public ReferentDB() {
    }

    public ReferentDB(UserDB userDB, boolean isOffline) {
        this.userDB = userDB;
        this.isOffline = isOffline;
    }
}
