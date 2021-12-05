package com.dataart.it.leaders.rest.api.controller;

import com.dataart.it.leaders.rest.api.service.PermutationService;
import com.dataart.it.leaders.rest.api.service.impl.PermitationServiceImp;
import com.datart.it.leaders.core.lib.model.bound.BNBResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PermutationController {

  private PermitationServiceImp permutationService;

    public PermutationController() {
    }

    public PermutationController(PermitationServiceImp permutationService) {
        this.permutationService = permutationService;
    }

    @GetMapping(value = "getInitialPermutation")
    public List getInitialPermutation(){
        return permutationService.getInitialPermutation();
    }



    @GetMapping(value = "getLowMetric")
    public Long getLowMetric(){
        return permutationService.getLowMetric();
    }

    @GetMapping(value = "getHighMetric")
    public Long getHighMetric(){
        return permutationService.getHighMetric();
    }
}
