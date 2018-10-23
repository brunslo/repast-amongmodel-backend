package com.repast.among.model.backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class ParametersController {
    private final Map<String, String> parameterMap = new ConcurrentHashMap<>();

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
}
