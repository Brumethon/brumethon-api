package com.brumethon.app.domain.referent;

import com.brumethon.app.domain.referent.exception.InvalidReferentException;
import com.brumethon.app.domain.user.UserValidator;
import com.brumethon.kernel.Validator;

public class ReferentValidator implements Validator<Referent> {

    private final UserValidator userValidator;

    public ReferentValidator(UserValidator userValidator) {
        this.userValidator = userValidator;
    }

    @Override
    public void validate(Referent referent) {
        if(referent == null) {
            throw new IllegalArgumentException("referent to validate is null");
        }

        if(referent.getUser() == null){
            throw new InvalidReferentException("referent user can not be null");
        }

        userValidator.validate(referent.getUser());

        if( referent.getDistanceMax() <= 0){
            throw  new InvalidReferentException("referent distance max can not be less or equal to 0");
        }

    }
}
