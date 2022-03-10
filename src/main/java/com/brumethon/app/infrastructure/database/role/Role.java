package com.brumethon.app.infrastructure.database.role;

import com.brumethon.app.infrastructure.database.user.User;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Role {
    @Id
    private String name;

    @ManyToMany
    private Set<User> user;
}
