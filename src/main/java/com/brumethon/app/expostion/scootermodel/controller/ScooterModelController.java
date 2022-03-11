package com.brumethon.app.expostion.scootermodel.controller;

import com.brumethon.app.expostion.error.ErrorHandler;
import com.brumethon.app.expostion.scootermodel.dto.ScooterModelDTO;
import com.brumethon.app.infrastructure.service.ScooterModelService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ScooterModelController extends ErrorHandler {

    private final ScooterModelService scooterModelService;

    public ScooterModelController(ScooterModelService scooterModelService) {
        this.scooterModelService = scooterModelService;
    }

    @GetMapping(value = "/models/{id}")
    public ScooterModelDTO getModel(@PathVariable @Valid long id) {
        return new ScooterModelDTO(id,scooterModelService.get(id).getName());
    }

    @GetMapping(value = "/models")
    public List<ScooterModelDTO> getModels() {
        return scooterModelService.getAll().stream()
                .map(scooterModel -> new ScooterModelDTO(scooterModel.getID(),scooterModel.getName()))
                .collect(Collectors.toList());
    }
}