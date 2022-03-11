package com.brumethon.app.expostion.problemstatus.controller;

import com.brumethon.app.domain.problemestatus.ProblemStatus;
import com.brumethon.app.expostion.problemstatus.dto.ProblemStatusDTO;
import com.brumethon.app.infrastructure.service.ProblemStatusService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProblemStatusController {

    private final ProblemStatusService problemStatusService;

    public ProblemStatusController(ProblemStatusService problemStatusService) {
        this.problemStatusService = problemStatusService;
    }

    @GetMapping(value = "problemstatus")
    public List<ProblemStatusDTO> getProblemStatus() {
        return problemStatusService.getAll().stream()
                .map(problemStatus -> new ProblemStatusDTO(problemStatus.getName())).collect(Collectors.toList());
    }

    @GetMapping(value = "problemstatus/{status}")
    public ProblemStatusDTO getProblemStatusByStatus(@PathVariable @Valid String status) {
        ProblemStatus problemStatus = problemStatusService.getByName(status);
        return new ProblemStatusDTO(problemStatus.getName());
    }
}
