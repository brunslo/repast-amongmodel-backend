package com.repast.among.model.backend.controllers;

import com.repast.among.model.backend.domain.RepastWrapperFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class DemoController {
    @RequestMapping("/")
    public String index() {

        Map<String,Map<String, Object>> list = new HashMap<String,Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("foo1", "bar1");
        map.put("foo2", "bar2");
        list.put("Parameter1", map);
        System.out.print(list);
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
