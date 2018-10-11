package com.repast.among.model.backend.controllers;


import com.repast.among.model.backend.services.AmongModelService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
