package com.brumethon.app.domain.role.exception;

import com.brumethon.app.domain.role.Role;
import com.brumethon.kernel.Validator;

public class InvalidRoleException implements Validator<Role> {
    @Override
    public void validate(Role role) {

    }
}
