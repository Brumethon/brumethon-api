package com.brumethon.app.infrastructure.service;

import com.brumethon.app.domain.problem.Problem;
import com.brumethon.app.domain.problem.ProblemRepository;
import com.brumethon.kernel.SimpleService;
import com.brumethon.kernel.Validator;
import org.springframework.stereotype.Service;

@Service
public class ProblemService extends SimpleService<ProblemRepository, Problem, Long> {
    public ProblemService(ProblemRepository repository, Validator<Problem> validator) {
        super(repository, validator, "problem");
    }
}
