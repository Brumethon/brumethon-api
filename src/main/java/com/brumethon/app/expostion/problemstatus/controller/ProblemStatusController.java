package com.brumethon.app.expostion.problemstatus.controller;

import com.brumethon.app.domain.problemestatus.ProblemStatus;
import com.brumethon.app.expostion.error.ErrorHandler;
import com.brumethon.app.expostion.problemstatus.dto.CreateProblemStatusDTO;
import com.brumethon.app.expostion.problemstatus.dto.ProblemStatusDTO;
import com.brumethon.app.infrastructure.service.ProblemStatusService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ProblemStatusController extends ErrorHandler {

    private final ProblemStatusService problemStatusService;

    public ProblemStatusController(ProblemStatusService problemStatusService) {
        this.problemStatusService = problemStatusService;
    }

    @GetMapping(value = "/problemstatus")
    public List<ProblemStatusDTO> getProblemStatus() {
        return problemStatusService.getAll().stream()
                .map(problemStatus -> new ProblemStatusDTO(problemStatus.getID(), problemStatus.getName())).collect(Collectors.toList());
    }

    @GetMapping(value = "/problemstatus/{status}")
    public ProblemStatusDTO getProblemStatusByName(@PathVariable @Valid String status) {
        ProblemStatus problemStatus = problemStatusService.getByName(status);
        return new ProblemStatusDTO(problemStatus.getID(), problemStatus.getName());
    }

    @PostMapping(value = "/problemstatus")
    public void postCategory(@RequestBody @Valid CreateProblemStatusDTO createProblemStatusDTO) {
        problemStatusService.add(new ProblemStatus(-1L, createProblemStatusDTO.name));
    }
}
