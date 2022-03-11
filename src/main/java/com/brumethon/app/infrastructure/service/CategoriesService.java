package com.brumethon.app.infrastructure.service;

import com.brumethon.app.domain.categories.Categories;
import com.brumethon.app.domain.categories.CategoriesRepository;
import com.brumethon.app.domain.user.User;
import com.brumethon.kernel.SimpleService;
import com.brumethon.kernel.Validator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService extends SimpleService<CategoriesRepository, Categories, Long> {
    public CategoriesService(CategoriesRepository repository, Validator<Categories> validator) {
        super(repository, validator, "categories");
    }

    public List<User> getAllCategoriesUsers(Long categoryID){
        return repository.getAllCategoriesUsers(categoryID);
    }
}
