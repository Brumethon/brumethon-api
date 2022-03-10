package com.brumethon.app.domain.role;

import com.brumethon.app.domain.referent.exception.InvalidReferentException;
import com.brumethon.kernel.Validator;

public class RoleValidator implements Validator<Role> {
    @Override
    public void validate(Role role) {
        if(role == null) {
            throw new IllegalArgumentException("Role to validate is null");
        }

        if( role.getName() == null || role.getName().isEmpty()){
            throw new InvalidReferentException("Role name can not be empty");
        }
    }
}
