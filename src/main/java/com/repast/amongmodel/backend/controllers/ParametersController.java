package com.repast.amongmodel.backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/parameters")
public class ParametersController {
    private final Map<String, String> parameterMap = new ConcurrentHashMap<>();

    @PostMapping("/initialise")
    public ResponseEntity<?> initialise() {
        this.parameterMap.clear();
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<?> postParameters(@RequestBody final Map<String, String> parameterMap) {
        this.parameterMap.putAll(parameterMap);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/setParam")
    public ResponseEntity<?> putParameters(@RequestParam("name") final String name, @RequestParam("value") final String value) {

        this.parameterMap.put(name, value);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> getParameters() {
        return ResponseEntity.ok(parameterMap);
    }
}
