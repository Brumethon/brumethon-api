package com.brumethon.app.domain.categories;

import com.brumethon.kernel.Entity;

public class Categories extends Entity<Long> {

    private final String name;

    public Categories(Long id, String name) {
        super(id);
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
