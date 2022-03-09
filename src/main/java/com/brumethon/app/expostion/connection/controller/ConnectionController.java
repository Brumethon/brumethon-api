package com.brumethon.app.expostion.connection.controller;

import com.brumethon.app.expostion.connection.dto.SessionDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;

@Controller
public class ConnectionController {
    @GetMapping(value = "/")
    public SessionDTO getMember(@PathVariable @Valid String email) {
        return new SessionDTO();
    }
}
