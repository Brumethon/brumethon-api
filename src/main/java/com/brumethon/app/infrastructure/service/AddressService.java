package com.brumethon.app.infrastructure.service;

import com.brumethon.app.domain.address.Address;
import com.brumethon.app.domain.address.AddressRepository;
import com.brumethon.kernel.SimpleService;
import com.brumethon.kernel.Validator;

public class AddressService extends SimpleService<AddressRepository, Address, Long> {
    public AddressService(AddressRepository repository, Validator<Address> validator) {
        super(repository, validator, "address");
    }
}
