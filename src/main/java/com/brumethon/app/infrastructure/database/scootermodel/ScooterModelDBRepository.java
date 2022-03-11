package com.brumethon.app.infrastructure.database.scootermodel;

import com.brumethon.app.domain.scootermodel.ScooterModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ScooterModelDBRepository extends CrudRepository<ScooterModelDB, Long> {

    @Query("FROM ScooterModelDB WHERE name = :name")
    Optional<ScooterModelDB> findByName(@Param("name") String name);
}
