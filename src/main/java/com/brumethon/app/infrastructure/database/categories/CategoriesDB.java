package com.brumethon.app.infrastructure.database.categories;

import com.brumethon.app.infrastructure.database.user.UserDB;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Table(name = "categories")
@Entity
public class CategoriesDB {
    @Id
    private String name;
    @ManyToMany
    private Set<UserDB> userDBS;

    public CategoriesDB() {
    }

    public String getName() {
        return name;
    }
}
