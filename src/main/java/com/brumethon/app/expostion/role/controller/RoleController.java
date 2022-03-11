package com.brumethon.app.expostion.role.controller;


import com.brumethon.app.domain.categories.Categories;
import com.brumethon.app.domain.role.Role;
import com.brumethon.app.expostion.category.dto.CreateCategoryDTO;
import com.brumethon.app.expostion.error.ErrorHandler;
import com.brumethon.app.expostion.role.dto.CreateRoleDTO;
import com.brumethon.app.expostion.role.dto.RoleDTO;
import com.brumethon.app.infrastructure.service.RoleService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", allowedHeaders = "*")
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

    @PostMapping(value = "/roles")
    public void postCategory(@RequestBody @Valid CreateRoleDTO createRoleDTO) {
        roleService.add(new Role(-1L,createRoleDTO.name));
    }
}
