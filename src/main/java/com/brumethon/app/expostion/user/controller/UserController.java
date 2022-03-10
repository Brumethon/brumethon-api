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
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

@Controller
public class UserController {

    @Autowired
    private final InDBUserRepository inDBUserRepository;

    private Properties appProps;

    public UserController(InDBUserRepository inDBUserRepository) {
        this.inDBUserRepository = inDBUserRepository;

        String rootPath = getClass().getClassLoader().getResource("").getPath();
        String appConfigPath = rootPath + "application.properties";

        appProps = new Properties();
        try {
            appProps.load(new FileInputStream(appConfigPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping(value = "/users")
    public List<UserDTO> getUsers() {
        System.out.println(inDBUserRepository.getAll());
        return List.of();
    }

    @GetMapping(value = "/users/{email}")
    public UserDTO getUser(@PathVariable @Valid String email) {
        return new UserDTO();
    }

    @PostMapping(value = "/users")
    public void addUser(@RequestBody @Valid CreateUserDTO createUserDTO) {
        JOpenCageGeocoder jOpenCageGeocoder = new JOpenCageGeocoder(appProps.getProperty("open_cages.token"));
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
