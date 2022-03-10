package com.brumethon.app.expostion.user.controller;

import com.brumethon.app.expostion.user.dto.GetUserDTO;
import com.brumethon.app.expostion.user.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    @GetMapping(value = "/users")
    public List<UserDTO> getUsers() {
        return List.of();
    }

    @GetMapping(value = "/users/{email}")
    public UserDTO getUser(@PathVariable @Valid String email) {
        return new UserDTO();
    }

    @GetMapping(value = "/users")
    public UserDTO getUserByToken(@RequestBody @Valid GetUserDTO getUser) {
        return new UserDTO();
    }
}
