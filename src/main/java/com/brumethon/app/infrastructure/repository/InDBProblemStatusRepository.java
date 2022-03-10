package com.brumethon.app.infrastructure.repository;

import com.brumethon.app.domain.problemestatus.ProblemStatus;
import com.brumethon.app.domain.problemestatus.ProblemStatusRepository;

import java.util.List;
import java.util.Optional;

public class InDBProblemStatusRepository implements ProblemStatusRepository {
    @Override
    public Optional<ProblemStatus> get(Long key) {
        return Optional.empty();
    }

    @Override
    public Long add(ProblemStatus value) {
        return null;
    }

    @Override
    public boolean update(ProblemStatus value) {
        return false;
    }

    @Override
    public boolean remove(Long value) {
        return false;
    }

    @Override
    public List<ProblemStatus> getAll() {
        return null;
    }
}
