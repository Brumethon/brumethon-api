package com.brumethon.app.expostion.connection.controller;

import com.brumethon.app.domain.session.Session;
import com.brumethon.app.domain.user.User;
import com.brumethon.app.expostion.connection.dto.SessionDTO;
import com.brumethon.app.expostion.connection.dto.UserConnectionDTO;
import com.brumethon.app.expostion.user.dto.UserDTO;
import com.brumethon.app.infrastructure.database.user.UserDB;
import com.brumethon.app.infrastructure.repository.InDBSessionRepository;
import com.brumethon.app.infrastructure.repository.InDBUserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@RestController
public class AuthenticationController {

    private final InDBSessionRepository inDBSessionRepository;
    private final InDBUserRepository inDBUserRepository;
    private static final int EXPIRATION_OF_TOKEN_IN_HOUR = 4;

    public AuthenticationController(InDBSessionRepository inDBSessionRepository, InDBUserRepository inDBUserRepository) {
        this.inDBSessionRepository = inDBSessionRepository;
        this.inDBUserRepository = inDBUserRepository;
    }

    @PostMapping(value = "/login")
    public SessionDTO login(@RequestBody @Valid UserConnectionDTO userConnectionDTO) {
        User user = inDBUserRepository.getByEmail(userConnectionDTO.email);
        UserDB userDB = UserDB.of(user);
        if(Objects.equals(user.getPassword(), userConnectionDTO.password)) {
            inDBSessionRepository.removeAllForUserID(userDB);
            return new SessionDTO(inDBSessionRepository.add(new Session(user, LocalDateTime.now().plusHours(EXPIRATION_OF_TOKEN_IN_HOUR))));
        }
        return null;
    }
}
