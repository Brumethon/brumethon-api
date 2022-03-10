package com.brumethon.app.infrastructure.repository;

import com.brumethon.app.domain.address.Address;
import com.brumethon.app.domain.address.AddressRepository;
import com.brumethon.app.domain.user.User;
import com.brumethon.app.domain.user.UserRepository;
import com.brumethon.app.infrastructure.database.address.AddressDB;
import com.brumethon.app.infrastructure.database.user.UserDB;
import com.brumethon.app.infrastructure.database.user.UserDBRepository;
import com.brumethon.kernel.email.EmailAddress;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public class InDBUserRepository implements UserRepository {

    private final UserDBRepository dbRepository;

    private final AddressRepository addressRepository;

    public InDBUserRepository(UserDBRepository dbRepository, AddressRepository addressRepository) {
        this.dbRepository = dbRepository;
        this.addressRepository = addressRepository;
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
                new EmailAddress(userDB.getMail()),
                userDB.getFirstName(),
                userDB.getLastName(),
                userDB.getPassword(),
                userDB.getPhoneNumber(),
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
}
