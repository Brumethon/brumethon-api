package com.brumethon.app.domain.role;

import com.brumethon.kernel.Entity;

public class Role extends Entity<String> {
    public Role(String name) {
        super(name);
    }

    public String getName(){
        return id;
    }
}
