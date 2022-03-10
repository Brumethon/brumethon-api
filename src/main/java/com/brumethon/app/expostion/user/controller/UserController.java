package com.brumethon.app.expostion.user.controller;

import com.brumethon.app.domain.address.Address;
import com.brumethon.app.domain.user.User;
import com.brumethon.app.expostion.user.dto.CreateUserDTO;
import com.brumethon.app.expostion.user.dto.UserDTO;
import com.brumethon.app.infrastructure.repository.InDBUserRepository;
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

    @Autowired
    private final InDBUserRepository inDBUserRepository;

    @Value("${open_cages.token}")
    private String token;


    public UserController(InDBUserRepository inDBUserRepository) {
        this.inDBUserRepository = inDBUserRepository;
    }

    @GetMapping(value = "/users")
    public List<UserDTO> getUsers() {
        return inDBUserRepository.getAll().stream()
                .map(user -> new UserDTO(
                        user.getEmailAddress().toString(),
                        user.getLastName(),
                        user.getFirstName(),
                        user.getAddress().toString()))
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/users/{email}")
    public UserDTO getUser(@PathVariable @Valid String email) {
        User user = inDBUserRepository.getByEmail(email);
        return new UserDTO(user.getEmailAddress().toString(), user.getLastName(), user.getFirstName(), user.getAddress().toString());
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

        this.inDBUserRepository.add(new User(
                -1L,
                new EmailAddress(createUserDTO.email),
                createUserDTO.firstname,
                createUserDTO.lastname,
                createUserDTO.password,
                createUserDTO.phoneNumber,
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
