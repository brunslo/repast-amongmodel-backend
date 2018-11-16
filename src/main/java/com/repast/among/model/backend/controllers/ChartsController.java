package com.repast.among.model.backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;
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

        Collections.sort(charts, new Comparator<Map<String, String>>() {
            @Override
            public int compare(Map<String, String> o1, Map<String, String> o2) {
                return new BigDecimal(o1.get("tick")).compareTo(new BigDecimal(o2.get("tick")));
            }
        });

        return ResponseEntity.ok(charts);
    }

}
