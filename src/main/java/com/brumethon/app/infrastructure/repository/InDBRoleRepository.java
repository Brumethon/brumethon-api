package com.brumethon.app.infrastructure.repository;

import com.brumethon.app.domain.role.Role;
import com.brumethon.app.domain.role.RoleRepository;
import com.brumethon.app.infrastructure.database.role.RoleDBRepository;

import java.util.List;
import java.util.Optional;

public class InDBRoleRepository implements RoleRepository {

    private final RoleDBRepository dbRepository;

    public InDBRoleRepository(RoleDBRepository dbRepository) {
        this.dbRepository = dbRepository;
    }

    @Override
    public Optional<Role> get(Long key) {
        return Optional.empty();
    }

    @Override
    public Long add(Role value) {
        return null;
    }

    @Override
    public boolean update(Role value) {
        return false;
    }

    @Override
    public boolean remove(Long value) {
        return false;
    }

    @Override
    public List<Role> getAll() {

        return null;
    }
}
