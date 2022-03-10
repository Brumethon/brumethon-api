package com.brumethon.app.infrastructure.repository;

import com.brumethon.app.domain.address.Address;
import com.brumethon.app.domain.user.User;
import com.brumethon.kernel.InMemoryRepositoryTest;
import com.brumethon.kernel.Repository;
import com.brumethon.kernel.email.EmailAddress;

import java.util.ArrayList;
import java.util.List;

class InMemoryUserRepositoryTest extends InMemoryRepositoryTest<User, Integer> {


    static Address defaultValidAddress = new Address(1L, "", "", "", "", "", 0.0, 0.0);

    public InMemoryUserRepositoryTest() {
        super( new User(1, new EmailAddress("test@test.com"), "bob", "bob", "p", defaultValidAddress),
                new User(2, new EmailAddress(""), "bob", "bob", "p", defaultValidAddress));
    }

    @Override
    protected Repository<User, Integer> getNewRepository(List<User> values) {
        return new InMemoryUserRepository(new ArrayList<>(values));
    }

    @Override
    protected User getUpdateValue1() {
        return new User(1, new EmailAddress("test@test.com"), "bob2", "bob2", "p", defaultValidAddress);
    }
}