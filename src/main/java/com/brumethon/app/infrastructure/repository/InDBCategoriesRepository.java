package com.brumethon.app.infrastructure.repository;

import com.brumethon.app.domain.categories.Categories;
import com.brumethon.app.domain.categories.CategoriesRepository;

import java.util.List;
import java.util.Optional;

public class InDBCategoriesRepository implements CategoriesRepository {
    @Override
    public Optional<Categories> get(String key) {
        return Optional.empty();
    }

    @Override
    public String add(Categories value) {
        return null;
    }

    @Override
    public boolean update(Categories value) {
        return false;
    }

    @Override
    public boolean remove(String value) {
        return false;
    }

    @Override
    public List<Categories> getAll() {
        return null;
    }
}
