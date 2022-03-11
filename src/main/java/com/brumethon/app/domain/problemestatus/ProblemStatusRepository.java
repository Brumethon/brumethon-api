package com.brumethon.app.domain.problemestatus;

import com.brumethon.kernel.Repository;

import java.util.Optional;

public interface ProblemStatusRepository extends Repository<ProblemStatus, Long> {


    Optional<ProblemStatus> getByName(String name);
}
