package com.dataart.it.leaders.rest.api.controller;

import com.dataart.it.leaders.rest.api.service.PermutationService;
import com.dataart.it.leaders.rest.api.service.impl.PermitationServiceImp;
import com.datart.it.leaders.core.lib.model.bound.BNBResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping(value = "createInitialPermutation")
    public void create(List initialPermutation){
        permutationService.createInitialPermutation(initialPermutation);
    }


}
