package au.edu.unimelb.eresearch.repast.amongmodel.backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/api/charts")
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
        charts.sort(Comparator.comparing(o -> new BigDecimal(o.getOrDefault("tick", "-1"))));

        return ResponseEntity.ok(charts);
    }

}
