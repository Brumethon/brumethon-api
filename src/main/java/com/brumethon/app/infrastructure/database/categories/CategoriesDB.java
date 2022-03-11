package com.brumethon.app.infrastructure.database.categories;

import com.brumethon.app.domain.categories.Categories;

import javax.persistence.*;

@Table(name = "categories")
@Entity
public class CategoriesDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categories_id")
    private Long categories_id;

    private String name;

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
}
