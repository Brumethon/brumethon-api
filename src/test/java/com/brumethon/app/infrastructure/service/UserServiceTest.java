package com.brumethon.app.infrastructure.service;

import com.brumethon.app.domain.user.User;
import com.brumethon.app.domain.user.UserRepository;
import com.brumethon.app.domain.user.UserValidator;
import com.brumethon.app.infrastructure.repository.InMemoryUserRepository;
import com.brumethon.kernel.SimpleService;
import com.brumethon.kernel.SimpleServiceTest;
import com.brumethon.kernel.Validator;
import com.brumethon.kernel.email.EmailAddress;
import com.brumethon.kernel.email.SimpleEmailAddressValidator;

import java.util.List;

class UserServiceTest extends SimpleServiceTest<UserRepository, User, Integer> {

    public UserServiceTest() {
        super(new User(1, new EmailAddress("test@test.com"), "bob", "bob", "p"),
                new User(2, new EmailAddress("test@test.com"), "bob", "bob", "p"));
    }

    @Override
    protected Validator<User> getNewValidator() {
        return new UserValidator(new SimpleEmailAddressValidator());
    }

    @Override
    protected UserRepository getNewRepository(List<User> values) {
        return new InMemoryUserRepository(values);
    }

    @Override
    protected UserRepository getNewRepository() {
        return new InMemoryUserRepository();
    }

    @Override
    protected SimpleService<UserRepository, User, Integer> getNewService() {
        return new UserService(getNewRepository(), (UserValidator) getNewValidator());
    }

    @Override
    protected SimpleService<UserRepository, User, Integer> getNewService(UserRepository repo, Validator<User> validator) {
        return new UserService(repo, (UserValidator) validator);
    }
}