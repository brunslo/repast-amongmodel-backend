package com.repast.among.model.backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/charts")
public class ChartsController {
    private final List<Map<String, String>> charts = new CopyOnWriteArrayList<>();

    @PostMapping("/initialise")
    public ResponseEntity<?> initialise() {
        charts.clear();

        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<?> postCharts(@RequestBody final List<Map<String, String>> charts) {
        this.charts.clear();
        this.charts.addAll(charts);

        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<?> putCharts(@RequestBody final Map<String, String> chartMap) {
        this.charts.add(chartMap);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> getCharts() {
        return ResponseEntity.ok(charts);
    }
}
