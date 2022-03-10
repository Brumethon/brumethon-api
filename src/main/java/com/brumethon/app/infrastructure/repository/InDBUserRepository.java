package com.brumethon.app.infrastructure.repository;

import com.brumethon.app.domain.address.Address;
import com.brumethon.app.domain.user.User;
import com.brumethon.app.infrastructure.database.address.AddressDB;
import com.brumethon.app.infrastructure.database.address.AddressRepository;
import com.brumethon.app.infrastructure.database.user.UserDB;
import com.brumethon.app.infrastructure.database.user.UserRepository;
import com.brumethon.kernel.Repository;
import com.brumethon.kernel.email.EmailAddress;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public class InDBUserRepository implements Repository<User, Integer> {

    @Autowired
    private UserRepository dbRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Optional<User> get(Integer key) {
        return Optional.empty();
    }

    @Override
    public void add(User value) {
        addressRepository.save(AddressDB.of(value.getAddress()));
        dbRepository.save(UserDB.of(value));
    }

    @Override
    public boolean update(User value) {
        return false;
    }

    @Override
    public boolean remove(Integer value) {
        return false;
    }

    @Override
    public List<User> getAll() {
        List<User> result = new ArrayList<>();
        dbRepository.findAll().forEach(userDB -> result.add(new User(
                Math.toIntExact(userDB.getId()),
                new EmailAddress(userDB.getMail()),
                userDB.getFirstName(),
                userDB.getLastName(),
                userDB.getPassword(),
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
