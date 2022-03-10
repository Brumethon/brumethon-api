package com.brumethon.app.infrastructure.service;

import com.brumethon.app.domain.role.Role;
import com.brumethon.app.domain.role.RoleRepository;
import com.brumethon.kernel.SimpleService;
import com.brumethon.kernel.Validator;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends SimpleService<RoleRepository, Role, Long> {
    public RoleService(RoleRepository repository, Validator<Role> validator) {
        super(repository, validator, "role");
    }
}
