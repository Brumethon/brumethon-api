package com.brumethon.app.expostion.problem.controller;

import com.brumethon.app.domain.categories.Categories;
import com.brumethon.app.domain.problem.Problem;
import com.brumethon.app.domain.problemestatus.ProblemStatus;
import com.brumethon.app.domain.scooter.Scooter;
import com.brumethon.app.expostion.category.dto.CategoryDTO;
import com.brumethon.app.expostion.problem.dto.CreateProblemDTO;
import com.brumethon.app.expostion.problem.dto.ProblemDTO;
import com.brumethon.app.expostion.scooter.dto.ScooterDTO;
import com.brumethon.app.infrastructure.service.CategoriesService;
import com.brumethon.app.infrastructure.service.ProblemService;
import com.brumethon.app.infrastructure.service.ProblemStatusService;
import com.brumethon.app.infrastructure.service.ScooterService;
import com.brumethon.kernel.coordinate.Coordinate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProblemController {

    private final ProblemService problemService;

    private final ProblemStatusService problemStatusService;

    private final CategoriesService categoriesService;

    private final ScooterService scooterService;

    public ProblemController(ProblemService problemService,
                             ProblemStatusService problemStatusService,
                             CategoriesService categoriesService,
                             ScooterService scooterService) {
        this.problemService = problemService;
        this.problemStatusService = problemStatusService;
        this.categoriesService = categoriesService;
        this.scooterService = scooterService;
    }

    @GetMapping(value = "/problems")
    public List<ProblemDTO> getAllProblems() {
        return problemService.getAll().stream()
                .map(problem -> new ProblemDTO(
                        problem.getID(),
                        problem.getName(),
                        problem.getDescription(),
                        new ScooterDTO(
                                problem.getScooter().getID(),
                                problem.getScooter().getModel().getID(),
                                problem.getScooter().getSerialNumber()),
                        problem.getCoordinate().getLatitude(),
                        problem.getCoordinate().getLongitude(),
                        problem.getDate(),
                        new CategoryDTO(problem.getCategories().getID(), problem.getCategories().getName())))
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/problems/{id}")
    public ProblemDTO getProblem(@PathVariable @Valid Long id) {
        Problem problem = problemService.get(id);
        return new ProblemDTO(
                problem.getID(),
                problem.getName(),
                problem.getDescription(),
                new ScooterDTO(
                        problem.getScooter().getID(),
                        problem.getScooter().getModel().getID(),
                        problem.getScooter().getSerialNumber()),
                problem.getCoordinate().getLatitude(),
                problem.getCoordinate().getLongitude(),
                problem.getDate(),
                new CategoryDTO(problem.getCategories().getID(), problem.getCategories().getName()));
    }

    @PostMapping(value = "/problems")
    public void postProblem(@RequestBody @Valid CreateProblemDTO createProblemDTO) {
        Scooter scooter = scooterService.get(createProblemDTO.scooterId);
        Categories categories = categoriesService.get(createProblemDTO.categoryId);
        ProblemStatus problemStatus = problemStatusService.get(createProblemDTO.problemStatusId);

        this.problemService.add(new Problem(
                null,
                createProblemDTO.name,
                createProblemDTO.description,
                scooter,
                new Coordinate(createProblemDTO.latitude, createProblemDTO.longitude),
                LocalDate.now(),
                categories,
                problemStatus
        ));
    }
}
