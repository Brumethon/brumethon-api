package com.brumethon.app.infrastructure.repository;

import com.brumethon.app.domain.user.User;
import com.brumethon.app.domain.user.UserRepository;
import com.brumethon.app.infrastructure.database.categories.CategoriesDB;
import com.brumethon.app.infrastructure.database.categories.CategoriesDBRepository;
import com.brumethon.app.infrastructure.database.user.UserDB;
import com.brumethon.app.infrastructure.database.user.UserDBRepository;
import com.brumethon.kernel.email.EmailAddress;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InDBUserRepository implements UserRepository {

    private final UserDBRepository dbRepository;

    private final CategoriesDBRepository categoriesDBRepository;

    public InDBUserRepository(UserDBRepository dbRepository, CategoriesDBRepository categoriesDBRepository) {
        this.dbRepository = dbRepository;
        this.categoriesDBRepository = categoriesDBRepository;
    }

    public User getByEmail(String email) {
        UserDB userDB = this.dbRepository.getUserDBByMail(email).orElseThrow();
        return userDB.toUser();
    }

    @Override
    public Optional<User> get(Long key) {
        return Optional.empty();
    }

    @Override
    public Long add(User value) {
        UserDB userDB = dbRepository.save(UserDB.of(value));
        value.setId(userDB.getUser_id());
        return userDB.getUser_id();
    }

    @Override
    public boolean update(User value) {
        return false;
    }

    @Override
    public boolean remove(Long value) {
        return false;
    }

    @Override
    public List<User> getAll() {
        List<User> result = new ArrayList<>();
        dbRepository.findAll().forEach(userDB -> result.add(userDB.toUser()));
        return result;
    }

    @Override
    public Optional<User> getByEmail(EmailAddress emailAddress) {
        Optional<UserDB> userDB = dbRepository.getUserDBByMail(emailAddress.toString());
        if(userDB.isEmpty()){
            return Optional.empty();
        }

        return Optional.of( userDB.get().toUser());
    }

    @Override
    public boolean addCategoryToUser(EmailAddress emailAddress, Long categoryID) {
        Optional<UserDB> userDB = dbRepository.getUserDBByMail(emailAddress.toString());

        if(userDB.isEmpty()){
            return false;
        }

        Optional<CategoriesDB> categoriesDB =  categoriesDBRepository.findById(categoryID);

        if(categoriesDB.isEmpty()){
            return false;
        }

        userDB.get().getCategories().add(categoriesDB.get());

        UserDB userDB1 = dbRepository.save(userDB.get());
        return true;
    }

    @Override
    public boolean addRoleToUser(EmailAddress emailAddress, Long roleID) {
        return false;
    }
}
