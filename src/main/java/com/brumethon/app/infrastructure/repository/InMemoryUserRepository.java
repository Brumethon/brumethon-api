package com.brumethon.app.infrastructure.repository;

import com.brumethon.app.domain.user.User;
import com.brumethon.app.domain.user.UserRepository;
import com.brumethon.kernel.InMemoryRepository;
import com.brumethon.kernel.email.EmailAddress;

import java.util.List;
import java.util.Optional;

public class InMemoryUserRepository extends InMemoryRepository<User, Long> implements UserRepository {

    public InMemoryUserRepository(List<User> values) {
        super(values);
    }

    public InMemoryUserRepository() {
    }

    @Override
    public Optional<User> getByEmail(EmailAddress emailAddress) {
        return Optional.empty();
    }

    @Override
    public boolean addCategoryToUser(EmailAddress emailAddress, Long categoryID) {
        return false;
    }
}
