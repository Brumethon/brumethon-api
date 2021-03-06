package com.brumethon.app.infrastructure.service;

import com.brumethon.app.domain.problemestatus.ProblemStatus;
import com.brumethon.app.domain.problemestatus.ProblemStatusRepository;
import com.brumethon.kernel.SimpleService;
import com.brumethon.kernel.Validator;
import com.brumethon.kernel.exception.SimpleServiceObjectNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ProblemStatusService extends SimpleService<ProblemStatusRepository, ProblemStatus, Long> {
    public ProblemStatusService(ProblemStatusRepository repository, Validator<ProblemStatus> validator) {
        super(repository, validator, "problem status");
    }

    public ProblemStatus getByName(String name){
        return repository.getByName(name).orElseThrow(() -> new SimpleServiceObjectNotFoundException("problem status", name));
    }

}
