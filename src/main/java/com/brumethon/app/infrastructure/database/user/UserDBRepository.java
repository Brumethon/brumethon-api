package com.brumethon.app.infrastructure.database.user;

import org.springframework.data.repository.CrudRepository;

public interface UserDBRepository extends CrudRepository<UserDB, Long> {
}
