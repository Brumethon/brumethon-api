package com.brumethon.app.infrastructure.database.user;

import com.brumethon.app.domain.user.User;
import com.brumethon.app.infrastructure.database.address.AddressDB;
import com.brumethon.app.infrastructure.database.role.RoleDB;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Table(name = "user")
@Entity
public class UserDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mail;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate registerDate;
    @OneToOne(fetch = FetchType.LAZY)
    private AddressDB addressDB;
    @ManyToMany
    private Set<RoleDB> roleDB;

    protected UserDB() {
    }

    protected UserDB(String mail, String password, String firstName, String lastName, LocalDate registerDate, AddressDB addressDB) {
        this.mail = mail;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.registerDate = registerDate;
        this.addressDB = addressDB;
    }

    public static UserDB of(User user) {
        return new UserDB(
                user.getEmailAddress().toString(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                LocalDate.now(),
                AddressDB.of(user.getAddress()));
    }

    public Long getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public AddressDB getAddressDB() {
        return addressDB;
    }

    public Set<RoleDB> getRoleDB() {
        return roleDB;
    }

    public void setAddressDB(AddressDB addressDB) {
        this.addressDB = addressDB;
    }
}
