package com.brumethon.app.infrastructure.database.categories;

import com.brumethon.app.domain.categories.Categories;
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

    public CategoriesDB(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Set<UserDB> getUserDBS() {
        return userDBS;
    }

    public String getName() {
        return name;
    }

    public static CategoriesDB of(Categories categories){
        return new CategoriesDB(categories.getID(), categories.getName());
    }

    public Categories toCategories(){
        return new Categories(id, name);
    }
}
