package com.brumethon.app.infrastructure.service;

import com.brumethon.app.domain.user.User;
import com.brumethon.app.domain.user.UserRepository;
import com.brumethon.app.domain.user.UserValidator;
import com.brumethon.kernel.SimpleService;
import com.brumethon.kernel.exception.SimpleServiceException;
import com.brumethon.kernel.exception.SimpleServiceObjectAlreadyException;
import com.brumethon.kernel.exception.SimpleServiceObjectNotFoundException;

public class UserService extends SimpleService<UserRepository, User, Integer> {

    public UserService(UserRepository repository, UserValidator validator) {
        super(repository, validator);
    }

    @Override
    public SimpleServiceException getExceptionWhenObjectNotFound(Integer key) {
        return new SimpleServiceObjectNotFoundException("scooter model", key.toString());
    }

    @Override
    public SimpleServiceException getExceptionWhenObjectAlreadyPresent(Integer key) {
        return new SimpleServiceObjectAlreadyException("scooter model", key.toString());
    }
}
