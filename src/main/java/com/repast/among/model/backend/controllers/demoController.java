package com.repast.among.model.backend.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class demoController {
    @RequestMapping("/")
    public String index() {
        return "Greetings from Repast AMONG Backend Spring Boot!";
    }

}
