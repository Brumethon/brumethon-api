package com.brumethon.app.infrastructure.repository;

import com.brumethon.app.domain.address.Address;
import com.brumethon.app.domain.address.AddressRepository;
import com.brumethon.app.infrastructure.database.address.AddressDB;
import com.brumethon.app.infrastructure.database.address.AddressDBRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public class InDBAddressRepository implements AddressRepository {

    @Autowired
    private AddressDBRepository dbRepository;

    @Override
    public Optional<Address> get(Long key) {
        return Optional.of(dbRepository.findById(key).orElseThrow().toAddress());
    }

    @Override
    public Long add(Address value) {
        AddressDB addressDB = dbRepository.save(AddressDB.of(value));
        value.setId(addressDB.getId());
        return addressDB.getId();
    }

    @Override
    public boolean update(Address value) {
        return false;
    }

    @Override
    public boolean remove(Long value) {
        dbRepository.deleteById(value);
        return dbRepository.existsById(value);
    }

    @Override
    public List<Address> getAll() {
        List<Address> addresses = new ArrayList<>();
        dbRepository.findAll().forEach(addressDB -> addresses.add(addressDB.toAddress()));
        return addresses;
    }
}
