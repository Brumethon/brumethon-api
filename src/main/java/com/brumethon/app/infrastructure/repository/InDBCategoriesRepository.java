package com.brumethon.app.infrastructure.repository;

import com.brumethon.app.domain.categories.Categories;
import com.brumethon.app.domain.categories.CategoriesRepository;
import com.brumethon.app.infrastructure.database.categories.CategoriesDB;
import com.brumethon.app.infrastructure.database.categories.CategoriesDBRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InDBCategoriesRepository implements CategoriesRepository {

    private final CategoriesDBRepository dbRepository;

    public InDBCategoriesRepository(CategoriesDBRepository dbRepository) {
        this.dbRepository = dbRepository;
    }

    @Override
    public Optional<Categories> get(Long key) {
        Optional<CategoriesDB> categoriesDB = dbRepository.findById(key);

        if (categoriesDB.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(categoriesDB.get().toCategories());
    }

    @Override
    public Long add(Categories value) {
        CategoriesDB categoriesDB = dbRepository.save(CategoriesDB.of(value));
        value.setId(categoriesDB.getId());
        return categoriesDB.getId();
    }

    @Override
    public boolean update(Categories value) {
        return false;
    }

    @Override
    public boolean remove(Long value) {
        dbRepository.deleteById(value);
        return dbRepository.existsById(value);
    }

    @Override
    public List<Categories> getAll() {
        List<Categories> result = new ArrayList<>();
        dbRepository.findAll().forEach(categoriesDB -> result.add(categoriesDB.toCategories()));
        return result;
    }
}
