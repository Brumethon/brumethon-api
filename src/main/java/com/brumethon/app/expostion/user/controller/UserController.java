package com.brumethon.app.expostion.user.controller;

import com.brumethon.app.domain.address.Address;
import com.brumethon.app.domain.user.User;
import com.brumethon.app.expostion.category.dto.CategoryDTO;
import com.brumethon.app.expostion.user.dto.CreateUserDTO;
import com.brumethon.app.expostion.user.dto.UserDTO;
import com.brumethon.app.infrastructure.database.categories.CategoriesDB;
import com.brumethon.app.infrastructure.repository.InDBUserRepository;
import com.brumethon.app.infrastructure.service.UserService;
import com.brumethon.kernel.email.EmailAddress;
import com.byteowls.jopencage.JOpenCageGeocoder;
import com.byteowls.jopencage.model.JOpenCageForwardRequest;
import com.byteowls.jopencage.model.JOpenCageLatLng;
import com.byteowls.jopencage.model.JOpenCageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

@RestController
public class UserController {

    private final UserService userService;

    @Value("${open_cages.token}")
    private String token;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public List<UserDTO> getUsers() {
        return userService.getAll().stream()
                .map(user -> new UserDTO(
                        user.getEmailAddress().toString(),
                        user.getLastName(),
                        user.getFirstName(),
                        user.getAddress().toString()))
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/users/{email}")
    public UserDTO getUserByEmail(@PathVariable @Valid String email) {
        User user = userService.getByEmail(new EmailAddress(email));
        return new UserDTO(user.getEmailAddress().toString(), user.getLastName(), user.getFirstName(), user.getAddress().toString());
    }

    @GetMapping(value = "/users/{email}/categories")
    public List<CategoryDTO> getUserCategories(@PathVariable @Valid String email) {
        User user = userService.getByEmail( new EmailAddress(email) );
        return user.getCategories().stream().map(categories -> new CategoryDTO(categories.getName())).collect(Collectors.toList());
    }

    @PostMapping(value = "/users/{email}/categories/{id}")
    public void addUserCategories(@PathVariable @Valid String email, @PathVariable @Valid Long id) {
        userService.addCategoryToUser(new EmailAddress(email), id);
    }

    @PostMapping(value = "/users")
    public void addUser(@RequestBody @Valid CreateUserDTO createUserDTO) {
        JOpenCageGeocoder jOpenCageGeocoder = new JOpenCageGeocoder(token);
        JOpenCageForwardRequest request = new JOpenCageForwardRequest(
                createUserDTO.address.number + " " +
                        createUserDTO.address.street + ", " +
                        createUserDTO.address.postalCode);
        request.setRestrictToCountryCode("fr");

        JOpenCageResponse response = jOpenCageGeocoder.forward(request);
        JOpenCageLatLng firstResultLatLng = response.getFirstPosition();

        userService.add(new User(
                -1L,
                createUserDTO.firstname,
                createUserDTO.lastname,
                createUserDTO.password,
                createUserDTO.phoneNumber,
                new EmailAddress(createUserDTO.email),
                new Address(
                        -1L,
                        createUserDTO.address.city,
                        createUserDTO.address.street,
                        createUserDTO.address.number,
                        createUserDTO.address.country,
                        createUserDTO.address.postalCode,
                        firstResultLatLng.getLat(),
                        firstResultLatLng.getLng())
        ));
    }

//    @GetMapping(value = "/users")
//    public UserDTO getUserByToken(@RequestBody @Valid GetUserDTO getUser) {
//        return new UserDTO();
//    }
}
