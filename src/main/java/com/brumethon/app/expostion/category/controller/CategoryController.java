package com.brumethon.app.expostion.category.controller;

import com.brumethon.app.domain.categories.Categories;
import com.brumethon.app.expostion.category.dto.CategoryDTO;
import com.brumethon.app.infrastructure.repository.InDBCategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CategoryController {

    @Autowired
    private final InDBCategoriesRepository inDBCategoriesRepository;

    public CategoryController(InDBCategoriesRepository inDBCategoriesRepository) {
        this.inDBCategoriesRepository = inDBCategoriesRepository;
    }

    @GetMapping(value = "/categories")
    public List<CategoryDTO> getCategory() {
        return inDBCategoriesRepository.getAll().stream()
                .map(categories -> new CategoryDTO(categories.getName())).collect(Collectors.toList());
    }
}
