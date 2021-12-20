package com.dataart.it.leaders.rest.api.controller;


import com.dataart.it.leaders.rest.api.service.RunJob;
import com.dataart.it.leaders.rest.api.service.impl.PermitationServiceImp;
import com.dataart.it.leaders.rest.api.service.impl.RunJobImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
public class PermutationController {

  private PermitationServiceImp permutationService;
  private RunJob runJobimpl;

    public PermutationController() {
    }

    public PermutationController(PermitationServiceImp permutationService,RunJob runJobimpl ) {
        this.permutationService = permutationService;
        this.runJobimpl=runJobimpl;
    }

    @PostMapping(value = "createInitialPermutation")
    public void create(ArrayList<Object> initialPermutation, Integer countline){
        permutationService.createInitialPermutation(initialPermutation);
        runJobimpl.RunJob();
    }

    @PostMapping(value = "createMetric")
    public void createMetric(Long metric){
        permutationService.createLowMetric(metric);
    }

}
