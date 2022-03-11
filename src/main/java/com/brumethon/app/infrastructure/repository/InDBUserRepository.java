package com.brumethon.app.infrastructure.repository;

import com.brumethon.app.domain.address.Address;
import com.brumethon.app.domain.address.AddressRepository;
import com.brumethon.app.domain.user.User;
import com.brumethon.app.domain.user.UserRepository;
import com.brumethon.app.infrastructure.database.address.AddressDB;
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

    private final AddressRepository addressRepository;

    public InDBUserRepository(UserDBRepository dbRepository, CategoriesDBRepository categoriesDBRepository, AddressRepository addressRepository) {
        this.dbRepository = dbRepository;
        this.categoriesDBRepository = categoriesDBRepository;
        this.addressRepository = addressRepository;
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
        Long addressId = addressRepository.add(value.getAddress());
        Address address = addressRepository.get(addressId).orElseThrow();
        UserDB userDB = UserDB.of(value);
        userDB.setAddressDB(AddressDB.of(address));
        userDB = dbRepository.save(userDB);
        return userDB.getId();
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
        dbRepository.findAll().forEach(userDB -> result.add(new User(
                userDB.getId(),
                userDB.getFirstName(),
                userDB.getLastName(),
                userDB.getPassword(),
                userDB.getPhoneNumber(),
                new EmailAddress(userDB.getMail()),
                new Address(
                        userDB.getAddressDB().getId(),
                        userDB.getAddressDB().getCity(),
                        userDB.getAddressDB().getStreet(),
                        userDB.getAddressDB().getNumber(),
                        userDB.getAddressDB().getCountry(),
                        userDB.getAddressDB().getPostalCode(),
                        userDB.getAddressDB().getLatitude(),
                        userDB.getAddressDB().getLongitude())
        )));
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
}
