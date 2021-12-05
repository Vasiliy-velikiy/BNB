package com.dataart.it.leaders.rest.api.controller;

import com.dataart.it.leaders.rest.api.service.PermutationService;
import com.datart.it.leaders.core.lib.model.bound.BNBResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PermutationController {

   private PermutationService permutationService;
   private BNBResult bnbResult;

    public PermutationController() {

    }

    public PermutationController(PermutationService permutationService) {
        this.permutationService = permutationService;
    }

    public PermutationController(BNBResult bnbResult) {
        this.bnbResult = bnbResult;
    }

    public PermutationController(PermutationService permutationService, BNBResult bnbResult) {
        this.permutationService = permutationService;
        this.bnbResult = bnbResult;
    }

    @GetMapping(value = "getInitialPermutation")
    public List getInitialPermutation(){
        return permutationService.getInitialPermutation();
    }



    @GetMapping(value = "getLowMetric")
    public Long getLowMetric(){
        return bnbResult.getlMetric();
    }

    @GetMapping(value = "getHighMetric")
    public Long getHighMetric(){
        return bnbResult.gethMetric();
    }
}
