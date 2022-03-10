package com.brumethon.app.infrastructure.repository;

import com.brumethon.app.domain.problem.Problem;
import com.brumethon.app.domain.problem.ProblemRepository;

import java.util.List;
import java.util.Optional;

public class InDBProblemRepository implements ProblemRepository {
    @Override
    public Optional<Problem> get(Long key) {
        return Optional.empty();
    }

    @Override
    public Long add(Problem value) {
        return null;
    }

    @Override
    public boolean update(Problem value) {
        return false;
    }

    @Override
    public boolean remove(Long value) {
        return false;
    }

    @Override
    public List<Problem> getAll() {
        return null;
    }
}
