package com.brumethon.app.expostion.referent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReferentController {
    @PostMapping(value = "/referent")
    public void becomeReferent() {

    }

    @GetMapping(value = "/referent")
    public void getRequestStatus() {

    }


}
