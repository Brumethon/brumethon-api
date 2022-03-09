package com.brumethon.app.expostion.connection.controller;

import com.brumethon.app.expostion.connection.dto.SessionDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {
    @GetMapping(value = "/login")
    public SessionDTO login() {
        return new SessionDTO();
    }
}
