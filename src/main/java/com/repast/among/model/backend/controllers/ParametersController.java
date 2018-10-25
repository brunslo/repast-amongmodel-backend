package com.repast.among.model.backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

@RestController
public class ParametersController{
    private final Map<String, String> parameterMap = new ConcurrentHashMap<>();
    private final List<Object> allChartMap = Collections.synchronizedList(new ArrayList<>());

    @PostMapping("/initialise")
    public ResponseEntity<?> initialise(@RequestBody final Map<String, String> parameterMap) {
        this.parameterMap.clear();
        this.parameterMap.putAll(parameterMap);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/set-parameter")
    public ResponseEntity<?> setParameter(@RequestParam final String name, @RequestParam final String value) {
        parameterMap.put(name, value);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/parameters")
    public ResponseEntity<?> parameters() {
        return ResponseEntity.ok(parameterMap);
    }

    @PostMapping("/sendCharts")
    public ResponseEntity<?> sendCharts(@RequestBody final Map<String, java.lang.String> chartMap) {

        this.allChartMap.add(chartMap);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getCharts")
    public ResponseEntity<?> getCharts() {
        return ResponseEntity.ok(allChartMap);
    }

}
