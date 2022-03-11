package com.brumethon.app.expostion.category.controller;

import com.brumethon.app.expostion.category.dto.CategoryDTO;
import com.brumethon.app.expostion.user.dto.UserDTO;
import com.brumethon.app.infrastructure.service.CategoriesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CategoryController {

    private final CategoriesService categoriesService;

    public CategoryController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @GetMapping(value = "/categories")
    public List<CategoryDTO> getCategory() {
        return categoriesService.getAll().stream()
                .map(categories -> new CategoryDTO(categories.getName())).collect(Collectors.toList());
    }

    @GetMapping(value = "/categories/{id}/users")
    public List<UserDTO> getAllCategoriesUser(@PathVariable @Valid Long id) {
        return categoriesService.getAllCategoriesUsers(id).stream()
                .map(user -> new UserDTO( user.getEmailAddress().toString(), user.getLastName(), user.getFirstName(), user.getAddress().toString()))
                .collect(Collectors.toList());
    }
}
