package com.brumethon.app.infrastructure.database.categories;

import com.brumethon.app.domain.categories.Categories;
import com.brumethon.app.infrastructure.database.user.UserDB;

import javax.persistence.*;
import java.util.List;

@Table(name = "categories")
@Entity
public class CategoriesDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categories_id")
    private Long categories_id;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_categories",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "categories_id") })
    private List<UserDB> assignedUser;

    public CategoriesDB() {
    }

    public CategoriesDB(Long categories_id, String name) {
        this.categories_id = categories_id;
        this.name = name;
    }

    public Long getCategories_id() {
        return categories_id;
    }

    public String getName() {
        return name;
    }

    public static CategoriesDB of(Categories categories){
        return new CategoriesDB(categories.getID(), categories.getName());
    }

    public Categories toCategories(){
        return new Categories(categories_id, name);
    }

    public List<UserDB> getAssignedUser() {
        return assignedUser;
    }
}
