package com.brumethon.app.infrastructure.database.problems;

import com.brumethon.app.infrastructure.database.referent.Referent;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Table(schema = "categories")
@Entity
public class Categories {
    @Id
    private String name;
    @ManyToMany
    private Set<Referent> referents;

    public Categories() {
    }
}
