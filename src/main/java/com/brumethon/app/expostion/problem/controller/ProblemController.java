package com.brumethon.app.expostion.problem.controller;

import com.brumethon.app.domain.categories.Categories;
import com.brumethon.app.domain.problem.Problem;
import com.brumethon.app.domain.problemestatus.ProblemStatus;
import com.brumethon.app.domain.scooter.Scooter;
import com.brumethon.app.expostion.category.dto.CategoryDTO;
import com.brumethon.app.expostion.problem.dto.CreateProblemDTO;
import com.brumethon.app.expostion.problem.dto.ProblemDTO;
import com.brumethon.app.expostion.scooter.dto.ScooterDTO;
import com.brumethon.app.infrastructure.repository.InDBCategoriesRepository;
import com.brumethon.app.infrastructure.repository.InDBProblemRepository;
import com.brumethon.app.infrastructure.repository.InDBProblemStatusRepository;
import com.brumethon.app.infrastructure.repository.InDBScooterRepository;
import com.brumethon.kernel.coordinate.Coordinate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProblemController {

    @Autowired
    private final InDBProblemRepository inDBProblemRepository;

    @Autowired
    private final InDBProblemStatusRepository inDBProblemStatusRepository;

    @Autowired
    private final InDBCategoriesRepository inDBCategoriesRepository;

    @Autowired
    private final InDBScooterRepository inDBScooterRepository;

    public ProblemController(InDBProblemRepository inDBProblemRepository, InDBProblemStatusRepository inDBProblemStatusRepository, InDBCategoriesRepository inDBCategoriesRepository, InDBScooterRepository inDBScooterRepository) {
        this.inDBProblemRepository = inDBProblemRepository;
        this.inDBProblemStatusRepository = inDBProblemStatusRepository;
        this.inDBCategoriesRepository = inDBCategoriesRepository;
        this.inDBScooterRepository = inDBScooterRepository;
    }

    @GetMapping(value = "/problems")
    public List<ProblemDTO> getAllProblems() {
        return inDBProblemRepository.getAll().stream()
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
                        new CategoryDTO(problem.getCategories().getName())))
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/problems/{id}")
    public ProblemDTO getProblem(@PathVariable @Valid Long id) {
        Problem problem = inDBProblemRepository.get(id).orElseThrow();
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
                new CategoryDTO(problem.getCategories().getName()));
    }

    @PostMapping(value = "/problems")
    public void postProblem(@RequestBody @Valid CreateProblemDTO createProblemDTO) {
        Scooter scooter = inDBScooterRepository.get(createProblemDTO.scooterId).orElseThrow();
        Categories categories = inDBCategoriesRepository.get(createProblemDTO.categoryId).orElseThrow();
        ProblemStatus problemStatus = inDBProblemStatusRepository.get(createProblemDTO.problemStatusId).orElseThrow();

        this.inDBProblemRepository.add(new Problem(
                -1L,
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
