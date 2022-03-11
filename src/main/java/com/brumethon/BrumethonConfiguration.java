package com.brumethon;

import com.brumethon.app.domain.address.Address;
import com.brumethon.app.domain.address.AddressValidator;
import com.brumethon.app.domain.role.Role;
import com.brumethon.app.domain.role.RoleValidator;
import com.brumethon.app.domain.scooter.Scooter;
import com.brumethon.app.domain.scooter.ScooterValidator;
import com.brumethon.app.domain.scootermodel.ScooterModel;
import com.brumethon.app.domain.scootermodel.ScooterModelValidator;
import com.brumethon.app.domain.session.Session;
import com.brumethon.app.domain.session.SessionValidator;
import com.brumethon.app.domain.user.User;
import com.brumethon.app.domain.user.UserValidator;
import com.brumethon.kernel.Validator;
import com.brumethon.kernel.email.EmailAddress;
import com.brumethon.kernel.email.EmailAddressValidator;
import com.brumethon.kernel.email.SimpleEmailAddressValidator;
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

    @Bean
    public Validator<Scooter> getScooterValidator() {
        return new ScooterValidator((ScooterModelValidator) getScooterModelValidator(),(UserValidator) getUserValidator());
    }

    @Bean
    public Validator<User> getUserValidator() {
        return new UserValidator((AddressValidator) getAddressValidator(),(EmailAddressValidator) getEmailValidator());
    }

    @Bean
    public Validator<EmailAddress> getEmailValidator() {
        return new SimpleEmailAddressValidator();
    }

    @Bean
    public Validator<Address> getAddressValidator() {
        return new AddressValidator();
    }

    @Bean
    public Validator<Session> getSessionValidator() {
        return new SessionValidator();
    }
}
