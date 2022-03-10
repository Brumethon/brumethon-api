package com.brumethon.app.infrastructure.database.role;

import com.brumethon.app.infrastructure.database.user.UserDB;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Table(name = "role")
@Entity
public class RoleDB {
    @Id
    private String name;

    @ManyToMany
    private Set<UserDB> userDB;
}
