package com.brumethon.app.infrastructure.repository;

import com.brumethon.app.domain.address.Address;
import com.brumethon.app.domain.user.User;
import com.brumethon.kernel.InMemoryRepositoryTest;
import com.brumethon.kernel.Repository;
import com.brumethon.kernel.email.EmailAddress;

import java.util.ArrayList;
import java.util.List;

class InMemoryUserDBRepositoryTest extends InMemoryRepositoryTest<User, Long> {


    static Address defaultValidAddress = new Address(1L, "", "", "", "", "", 0.0, 0.0);

    public InMemoryUserDBRepositoryTest() {
        super( new User(1L, "bob", "bob", "p", "0601020304", new EmailAddress("test@test.com"), defaultValidAddress),
                new User(2L, "bob", "bob", "p", "0601020304", new EmailAddress(""), defaultValidAddress));
    }

    @Override
    protected Repository<User, Long> getNewRepository(List<User> values) {
        return new InMemoryUserRepository(new ArrayList<>(values));
    }

    @Override
    protected User getUpdateValue1() {
        return new User(1L,  "bob2", "bob2", "p", "0601020304",new EmailAddress("test@test.com"), defaultValidAddress);
    }
}
