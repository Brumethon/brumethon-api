package com.brumethon.app.infrastructure.service;

import com.brumethon.app.domain.problem.Problem;
import com.brumethon.app.domain.problem.ProblemRepository;
import com.brumethon.app.domain.user.User;
import com.brumethon.app.infrastructure.database.user.UserDB;
import com.brumethon.kernel.SimpleService;
import com.brumethon.kernel.Validator;
import com.brumethon.kernel.exception.SimpleServiceObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProblemService extends SimpleService<ProblemRepository, Problem, Long> {
    public ProblemService(ProblemRepository repository, Validator<Problem> validator) {
        super(repository, validator, "problem");
    }

    public void putReferentOnProblem(User user, Long problem_id) {
        Problem problem = repository.get(problem_id).orElseThrow(()->new SimpleServiceObjectNotFoundException("problem",problem_id.toString()));
        problem.setReferent(user);
        repository.update(problem);
    }

    public List<Problem> getAllAvailable(User user){
        List<Problem> list = repository.getAllAvailableProblem(user.getAssignedCategories().get(0).getID());
        return list.stream().filter(user::isUserAvailableForProblem).collect(Collectors.toList());
    }

}
