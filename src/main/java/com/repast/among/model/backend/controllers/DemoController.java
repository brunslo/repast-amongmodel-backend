package com.repast.among.model.backend.controllers;

import com.repast.among.model.backend.domain.RepastWrapperFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class DemoController {
    @RequestMapping("/")
    public String index() {

        return "Greetings from Repast AMONG Backend Spring Boot!";
    }

    @Value("${repast-simphony-model-name}")
    private String modelFileName;

    @RequestMapping("/demo")
    @GetMapping
    public String demo() {

        RepastWrapperFactory obj = new RepastWrapperFactory();
        obj.start(modelFileName);
        return "Demo test";
    }
}
