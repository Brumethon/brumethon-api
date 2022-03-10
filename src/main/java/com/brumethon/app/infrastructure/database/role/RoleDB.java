package com.brumethon.app.infrastructure.database.role;

import com.brumethon.app.domain.role.Role;
import com.brumethon.app.infrastructure.database.user.UserDB;

import javax.persistence.*;
import java.util.Set;

@Table(name = "role")
@Entity
public class RoleDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    private Set<UserDB> userDB;

    public RoleDB() {
    }

    public RoleDB(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static RoleDB of(Role role){
        return new RoleDB(role.getID(), role.getName());
    }

    public Role toRole(){
        return new Role(id, name);
    }
}
