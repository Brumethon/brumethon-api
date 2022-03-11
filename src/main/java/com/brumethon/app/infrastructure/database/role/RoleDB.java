package com.brumethon.app.infrastructure.database.role;

import com.brumethon.app.domain.role.Role;

import javax.persistence.*;

@Table(name = "role")
@Entity
public class RoleDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long role_id;

    private String name;

    public RoleDB() {
    }

    public RoleDB(Long role_id, String name) {
        this.role_id = role_id;
        this.name = name;
    }

    public Long getRole_id() {
        return role_id;
    }

    public String getName() {
        return name;
    }

    public static RoleDB of(Role role){
        return new RoleDB(role.getID(), role.getName());
    }

    public Role toRole(){
        return new Role(role_id, name);
    }
}
