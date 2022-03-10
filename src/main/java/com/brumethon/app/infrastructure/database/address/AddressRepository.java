package com.brumethon.app.infrastructure.database.address;

import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<AddressDB, Long> {
}
