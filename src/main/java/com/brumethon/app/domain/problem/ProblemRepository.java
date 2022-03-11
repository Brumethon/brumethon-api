package com.brumethon.app.domain.problem;

import com.brumethon.kernel.Repository;

import java.util.List;

public interface ProblemRepository extends Repository<Problem, Long> {

    List<Problem> getAllAvailableProblem(Long categoryID);
}
