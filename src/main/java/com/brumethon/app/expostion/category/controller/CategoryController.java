package com.brumethon.app.expostion.category.controller;

import com.brumethon.app.expostion.category.dto.CategoryDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CategoryController {

    @GetMapping(value = "/category")
    public List<CategoryDTO> getCategory() {
        return List.of();
    }


}
