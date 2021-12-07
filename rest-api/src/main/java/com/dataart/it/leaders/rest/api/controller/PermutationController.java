package com.dataart.it.leaders.rest.api.controller;


import com.dataart.it.leaders.rest.api.service.impl.PermitationServiceImp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
public class PermutationController {

  private PermitationServiceImp permutationService;

    public PermutationController() {
    }

    public PermutationController(PermitationServiceImp permutationService) {
        this.permutationService = permutationService;
    }

    @PostMapping(value = "createInitialPermutation")
    public void create(ArrayList<Object> initialPermutation){
        permutationService.createInitialPermutation(initialPermutation);
    }

    @PostMapping(value = "createMetric")
    public void createMetric(Long metric){
        permutationService.createLowMetric(metric);
    }
}
