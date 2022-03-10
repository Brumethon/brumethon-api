package com.brumethon.app.infrastructure.repository;

import com.brumethon.app.domain.problem.Problem;
import com.brumethon.app.domain.problem.ProblemRepository;
import com.brumethon.app.infrastructure.database.problems.ProblemsDBRepository;
import com.brumethon.app.infrastructure.database.problems.ProblemsDB;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InDBProblemRepository implements ProblemRepository {

    private final ProblemsDBRepository dbRepository;

    public InDBProblemRepository(ProblemsDBRepository dbRepository) {
        this.dbRepository = dbRepository;
    }

    @Override
    public Optional<Problem> get(Long key) {
        Optional<ProblemsDB> problemsDB = dbRepository.findById(key);


        if(problemsDB.isEmpty()){
            return Optional.empty();
        }

        return Optional.of( problemsDB.get().toProblem());
    }

    @Override
    public Long add(Problem value) {
        ProblemsDB problemsDB = dbRepository.save(ProblemsDB.of(value));
        value.setId(problemsDB.getId());
        return problemsDB.getId();
    }

    @Override
    public boolean update(Problem value) {
        return false;
    }

    @Override
    public boolean remove(Long value) {
        dbRepository.deleteById(value);
        return dbRepository.existsById(value);
    }

    @Override
    public List<Problem> getAll() {
        List<Problem> problems = new ArrayList<>();
        dbRepository.findAll().forEach(problemsDB -> problems.add(problemsDB.toProblem()));
        return problems;
    }
}
