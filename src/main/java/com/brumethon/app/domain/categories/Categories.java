package com.brumethon.app.domain.categories;

import com.brumethon.kernel.Entity;

public class Categories extends Entity<String> {
    public Categories(String name) {
        super(name);
    }

    public String getName(){
        return id;
    }
}
