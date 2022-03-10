package com.brumethon;

import com.brumethon.app.domain.role.Role;
import com.brumethon.app.domain.role.RoleValidator;
import com.brumethon.app.domain.scootermodel.ScooterModel;
import com.brumethon.app.domain.scootermodel.ScooterModelValidator;
import com.brumethon.kernel.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BrumethonConfiguration {

    @Bean
    public Validator<ScooterModel> getScooterModelValidator() {
        return new ScooterModelValidator();
    }

    @Bean
    public Validator<Role> getRoleValidator() {
        return new RoleValidator();
    }
}
