package com.brumethon.app.expostion.scooter.controller;

import com.brumethon.app.domain.scooter.Scooter;
import com.brumethon.app.domain.scootermodel.ScooterModel;
import com.brumethon.app.domain.session.Session;
import com.brumethon.app.expostion.error.ErrorHandler;
import com.brumethon.app.expostion.scooter.dto.ScooterDTO;
import com.brumethon.app.infrastructure.service.ScooterModelService;
import com.brumethon.app.infrastructure.service.ScooterService;
import com.brumethon.app.infrastructure.service.SessionService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class ScooterController extends ErrorHandler {

    private final ScooterService scooterService;
    private final ScooterModelService scooterModelService;
    private final SessionService sessionService;

    public ScooterController(ScooterService scooterService, ScooterModelService scooterModelService, SessionService sessionService) {
        this.scooterService = scooterService;
        this.scooterModelService = scooterModelService;
        this.sessionService = sessionService;
    }

    @GetMapping(value = "/scooters/{id}")
    public ScooterDTO getScooter(@PathVariable @Valid long id) {
        Scooter scooter = scooterService.get(id);
        return new ScooterDTO(scooter.getID(), scooter.getModel().getID(), scooter.getSerialNumber());
    }

    @GetMapping(value = "/scooters")
    public List<ScooterDTO> getScooters() {
        return scooterService.getAll().stream()
                .map(scooter -> new ScooterDTO(scooter.getID(), scooter.getModel().getID(), scooter.getSerialNumber()))
                .collect(Collectors.toList());
    }

    @PostMapping(value = "/scooters")
    public void putScooters(@RequestHeader("uuid") UUID uuid, @RequestBody @Valid ScooterDTO scooterDTO) {
        Session userSession = sessionService.get(uuid.toString());
        ScooterModel scooterModel = scooterModelService.get(scooterDTO.scooterModelID);
        scooterService.add(new Scooter(-1L, scooterDTO.serialNumber, scooterModel, userSession.getUser(), LocalDate.now()));
    }
}