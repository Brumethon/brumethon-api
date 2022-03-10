package com.brumethon.app.infrastructure.repository;

import com.brumethon.app.domain.user.User;
import com.brumethon.app.domain.user.UserRepository;
import com.brumethon.kernel.InMemoryRepository;

import java.util.List;

public class InMemoryUserRepository extends InMemoryRepository<User, Long> implements UserRepository {

    public InMemoryUserRepository(List<User> values) {
        super(values);
    }

    public InMemoryUserRepository() {
    }
}
