package com.brumethon.app.infrastructure.database.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<UserDB, Long> {
}
