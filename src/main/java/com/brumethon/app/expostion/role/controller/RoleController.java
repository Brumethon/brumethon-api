package com.brumethon.app.expostion.role.controller;


import com.brumethon.app.domain.role.Role;
import com.brumethon.app.expostion.error.ErrorHandler;
import com.brumethon.app.expostion.role.dto.RoleDTO;
import com.brumethon.app.infrastructure.service.RoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RoleController extends ErrorHandler {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping(value = "/roles")
    public List<RoleDTO> getUsers() {
        return roleService.getAll().stream().map(role -> new RoleDTO(role.getID(), role.getName())).collect(Collectors.toList());
    }

    @GetMapping(value = "/roles/{id}")
    public RoleDTO getUsers(@PathVariable @Valid Long id) {
        Role role =roleService.get(id);
        return new RoleDTO(role.getID(),role.getName());
    }
}
