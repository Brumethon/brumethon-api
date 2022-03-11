package com.brumethon.app.infrastructure.database.user;

import com.brumethon.app.domain.categories.Categories;
import com.brumethon.app.domain.user.User;
import com.brumethon.app.infrastructure.database.address.AddressDB;
import com.brumethon.app.infrastructure.database.categories.CategoriesDB;
import com.brumethon.app.infrastructure.database.role.RoleDB;
import com.brumethon.kernel.email.EmailAddress;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Table(name = "user")
@Entity
public class UserDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String mail;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private LocalDate registerDate;

    @OneToOne
    private AddressDB addressDB;

    @ManyToMany
    private Set<RoleDB> roleDB;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_categories",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "categories_id") })
    private List<CategoriesDB> categories;

    protected UserDB() {
    }

    protected UserDB(String mail, String password, String firstName, String lastName, String phoneNumber, LocalDate registerDate, AddressDB addressDB) {
        this.mail = mail;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.registerDate = registerDate;
        this.addressDB = addressDB;
    }

    protected UserDB(Long id, String mail, String password, String firstName, String lastName, String phoneNumber, LocalDate registerDate, AddressDB addressDB) {
        this.id = id;
        this.mail = mail;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.registerDate = registerDate;
        this.addressDB = addressDB;
    }

    public static UserDB of(User user) {
        return new UserDB(
                user.getID(),
                user.getEmailAddress().toString(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                user.getPhoneNumber(),
                LocalDate.now(),
                AddressDB.of(user.getAddress()));
    }

    public User toUser() {
        return new User(
                this.getId(),
                this.getFirstName(),
                this.getLastName(),
                this.getPassword(),
                this.getPhoneNumber(),
                new EmailAddress(this.getMail()),
                this.getAddressDB().toAddress(),
                categories.stream().map(categoriesDB -> new Categories(categoriesDB.getCategories_id(), categoriesDB.getName())).collect(Collectors.toList()) );
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

    public String getPhoneNumber() {
        return phoneNumber;
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

    public List<CategoriesDB> getCategories() {
        return categories;
    }
}
