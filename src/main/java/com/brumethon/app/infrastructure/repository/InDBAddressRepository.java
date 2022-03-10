package com.brumethon.app.infrastructure.repository;

import com.brumethon.app.domain.address.Address;
import com.brumethon.app.infrastructure.database.address.AddressDB;
import com.brumethon.app.infrastructure.database.address.AddressRepository;
import com.brumethon.kernel.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public class InDBAddressRepository implements Repository<Address, Long> {

    @Autowired
    private AddressRepository dbRepository;

    @Override
    public Optional<Address> get(Long key) {
        return Optional.empty();
    }

    @Override
    public void add(Address value) {
        dbRepository.save(AddressDB.of(value));
    }

    @Override
    public boolean update(Address value) {
        return false;
    }

    @Override
    public boolean remove(Long value) {
        return false;
    }

    @Override
    public List<Address> getAll() {
        return null;
    }
}
