package com.repast.among.model.backend.controllers;


import com.repast.among.model.backend.services.AmongModelService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/among-model")
@RequiredArgsConstructor
public class AmongModelController {

    @NonNull
    private final AmongModelService amongModelService;

    @GetMapping("/getInitialParam")
    public ResponseEntity<?> getInitialParam() {
        return ResponseEntity.ok(amongModelService.generateInitalParamMap());
    }


    @PostMapping(path="/setParam", consumes="application/json")
    public ResponseEntity<?> setParam(@RequestBody(required=false)  final Map<String,String> paramRequest) {
        amongModelService.setParamValue(paramRequest.get("paramKey"), paramRequest.get("paramValue"));
        return ResponseEntity.ok().build();
    }


    @PostMapping(path="/sendParamFromEclipse")
    public ResponseEntity<?> getParam(@RequestBody(required=false)  final Map<String,String> paramRequest) {
        System.out.println("Received from among model="+ paramRequest);
//        amongModelService.setParamValue(paramRequest.get("paramKey"), paramRequest.get("paramValue"));
        return ResponseEntity.ok().build();
    }

}
