package com.brumethon.app.infrastructure.repository;

import com.brumethon.app.domain.categories.Categories;
import com.brumethon.app.domain.categories.CategoriesRepository;

import java.util.List;
import java.util.Optional;

public class InDBCategoriesRepository implements CategoriesRepository {
    @Override
    public Optional<Categories> get(Long key) {
        return Optional.empty();
    }

    @Override
    public Long add(Categories value) {
        return null;
    }

    @Override
    public boolean update(Categories value) {
        return false;
    }

    @Override
    public boolean remove(Long value) {
        return false;
    }

    @Override
    public List<Categories> getAll() {
        return null;
    }
}
