package com.brumethon.app.expostion.problem.controller;

import com.brumethon.app.domain.categories.Categories;
import com.brumethon.app.domain.problem.Problem;
import com.brumethon.app.domain.problemestatus.ProblemStatus;
import com.brumethon.app.domain.scooter.Scooter;
import com.brumethon.app.domain.session.Session;
import com.brumethon.app.expostion.category.dto.CategoryDTO;
import com.brumethon.app.expostion.error.ErrorHandler;
import com.brumethon.app.expostion.problem.dto.CreateProblemDTO;
import com.brumethon.app.expostion.problem.dto.ProblemDTO;
import com.brumethon.app.expostion.scooter.dto.ScooterDTO;
import com.brumethon.app.expostion.user.dto.UserDTO;
import com.brumethon.app.infrastructure.database.user.UserDB;
import com.brumethon.app.infrastructure.service.*;
import com.brumethon.kernel.coordinate.Coordinate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ProblemController extends ErrorHandler {

    private final ProblemService problemService;

    private final ProblemStatusService problemStatusService;

    private final CategoriesService categoriesService;

    private final ScooterService scooterService;

    private final SessionService sessionService;

    public ProblemController(ProblemService problemService,
                             ProblemStatusService problemStatusService,
                             CategoriesService categoriesService,
                             ScooterService scooterService,
                             SessionService sessionService) {
        this.problemService = problemService;
        this.problemStatusService = problemStatusService;
        this.categoriesService = categoriesService;
        this.scooterService = scooterService;
        this.sessionService = sessionService;
    }

    @GetMapping(value = "/problems")
    public List<ProblemDTO> getAllProblems() {
        return problemService.getAll().stream()
                .map(problem -> {
                    UserDTO user = null;
                    if (problem.getReferent() != null) {
                        user = new UserDTO(
                                problem.getReferent().getEmailAddress().toString(),
                                problem.getReferent().getLastName(),
                                problem.getReferent().getLastName(),
                                problem.getReferent().getAddress().toString(),
                                problem.getReferent().getPhoneNumber());
                    }
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
                        user,
                        new CategoryDTO(problem.getCategories().getID(), problem.getCategories().getName()));
                })
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/problems/{id}")
    public ProblemDTO getProblem(@PathVariable @Valid Long id) {
        Problem problem = problemService.get(id);

        UserDTO user = null;
        if (problem.getReferent() != null) {
            user = new UserDTO(
                    problem.getReferent().getEmailAddress().toString(),
                    problem.getReferent().getLastName(),
                    problem.getReferent().getLastName(),
                    problem.getReferent().getAddress().toString(),
                    problem.getReferent().getPhoneNumber());
        }

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
                user,
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

    @PutMapping(value = "/problems/{id}")
    public void putReferentOnProblem(@RequestHeader("uuid") UUID uuid, @PathVariable @Valid Long id) {
        Session userSession = sessionService.get(uuid.toString());
        problemService.putReferentOnProblem(userSession.getUser(),id);
    }
}
