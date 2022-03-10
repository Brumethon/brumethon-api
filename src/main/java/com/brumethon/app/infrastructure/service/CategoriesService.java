package com.brumethon.app.infrastructure.service;

import com.brumethon.app.domain.categories.Categories;
import com.brumethon.app.domain.categories.CategoriesRepository;
import com.brumethon.kernel.SimpleService;
import com.brumethon.kernel.Validator;

public class CategoriesService extends SimpleService<CategoriesRepository, Categories, String> {
    public CategoriesService(CategoriesRepository repository, Validator<Categories> validator) {
        super(repository, validator, "categories");
    }
}
