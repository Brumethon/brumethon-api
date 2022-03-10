package com.brumethon.app.infrastructure.database.categories;

import com.brumethon.app.infrastructure.database.user.UserDB;

import javax.persistence.*;
import java.util.Set;

@Table(name = "categories")
@Entity
public class CategoriesDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @ManyToMany
    private Set<UserDB> userDBS;

    public CategoriesDB() {
    }

    public String getName() {
        return name;
    }
}
