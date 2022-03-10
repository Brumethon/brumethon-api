package com.brumethon.app.infrastructure.repository;

import com.brumethon.app.domain.problemestatus.ProblemStatus;
import com.brumethon.app.domain.problemestatus.ProblemStatusRepository;
import com.brumethon.app.infrastructure.database.problemstatus.ProblemStatusDB;
import com.brumethon.app.infrastructure.database.problemstatus.ProblemStatusDBRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InDBProblemStatusRepository implements ProblemStatusRepository {

    private final ProblemStatusDBRepository dbRepository;

    public InDBProblemStatusRepository(ProblemStatusDBRepository dbRepository) {
        this.dbRepository = dbRepository;
    }

    public ProblemStatus getByName(String name) {
        ProblemStatusDB problemStatusDB = this.dbRepository.getProblemStatusDBByName(name).orElseThrow();
        return problemStatusDB.toProblemStatus();
    }

    @Override
    public Optional<ProblemStatus> get(Long key) {
        Optional<ProblemStatusDB> problemStatusDB  = dbRepository.findById(key);

        if(problemStatusDB.isEmpty()){
            return Optional.empty();
        }

        return Optional.of( problemStatusDB.get().toProblemStatus() );
    }

    @Override
    public Long add(ProblemStatus value) {
        ProblemStatusDB problemStatusDB = dbRepository.save(ProblemStatusDB.of(value));
        value.setId(problemStatusDB.getId());
        return problemStatusDB.getId();
    }

    @Override
    public boolean update(ProblemStatus value) {
        return false;
    }

    @Override
    public boolean remove(Long value) {
        dbRepository.deleteById(value);
        return dbRepository.existsById(value);
    }

    @Override
    public List<ProblemStatus> getAll() {
        List<ProblemStatus> list = new ArrayList<>();
        dbRepository.findAll().forEach(problemStatusDB -> list.add(problemStatusDB.toProblemStatus()));
        return list;
    }
}
