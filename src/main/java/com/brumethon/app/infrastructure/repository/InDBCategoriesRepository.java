package com.brumethon.app.infrastructure.repository;

import com.brumethon.app.domain.categories.Categories;
import com.brumethon.app.domain.categories.CategoriesRepository;
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
        List<Categories> result = new ArrayList<>();
        dbRepository.findAll().forEach(categoriesDB -> result.add(new Categories(
                categoriesDB.getName()
        )));
        return result;
    }
}
