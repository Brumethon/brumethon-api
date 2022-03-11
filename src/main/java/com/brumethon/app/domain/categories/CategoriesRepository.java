package com.brumethon.app.domain.categories;

import com.brumethon.app.domain.user.User;
import com.brumethon.kernel.Repository;

import java.util.List;

public interface CategoriesRepository extends Repository<Categories, Long> {

    List<User> getAllCategoriesUsers(Long id);
}
