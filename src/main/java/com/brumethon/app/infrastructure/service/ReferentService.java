package com.brumethon.app.infrastructure.service;

import com.brumethon.app.domain.referent.Referent;
import com.brumethon.app.domain.referent.ReferentRepository;
import com.brumethon.kernel.SimpleService;
import com.brumethon.kernel.Validator;

public class ReferentService extends SimpleService<ReferentRepository, Referent, Long> {
    public ReferentService(ReferentRepository repository, Validator<Referent> validator) {
        super(repository, validator, "referent");
    }
}
