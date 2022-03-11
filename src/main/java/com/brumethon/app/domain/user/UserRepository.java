package com.brumethon.app.domain.user;

import com.brumethon.kernel.Repository;
import com.brumethon.kernel.email.EmailAddress;

import java.util.Optional;

public interface UserRepository extends Repository<User, Long> {

    Optional<User> getByEmail(EmailAddress emailAddress);

    boolean addCategoryToUser(EmailAddress emailAddress, Long categoryID);

}
