package com.brumethon.app.domain.role;

import com.brumethon.app.domain.role.exception.InvalidRoleException;
import com.brumethon.kernel.Validator;

public class RoleValidator implements Validator<Role> {
    @Override
    public void validate(Role role) {
        if(role == null) {
            throw new IllegalArgumentException("Role to validate is null");
        }

        if( role.getName() == null || role.getName().isEmpty()){
            throw new InvalidRoleException("Role name can not be empty");
        }
    }
}
