package com.brumethon.app.infrastructure.service;

import com.brumethon.app.domain.user.User;
import com.brumethon.app.domain.user.UserRepository;
import com.brumethon.app.domain.user.UserValidator;
import com.brumethon.kernel.SimpleService;

public class UserService extends SimpleService<UserRepository, User, Long> {

    public UserService(UserRepository repository, UserValidator validator) {
        super(repository, validator, "user");
    }

}
