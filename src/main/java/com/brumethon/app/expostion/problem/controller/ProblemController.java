package com.brumethon.app.expostion.problem.controller;

import com.brumethon.app.expostion.error.ErrorHandler;
import com.brumethon.app.expostion.problem.dto.ProblemDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProblemController extends ErrorHandler {
    @PostMapping(value = "/problems")
    public ProblemDTO postProblem() {
        return new ProblemDTO();
    }
}
