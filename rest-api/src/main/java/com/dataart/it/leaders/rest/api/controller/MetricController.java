package com.dataart.it.leaders.rest.api.controller;

import com.dataart.it.leaders.rest.api.service.impl.PermitationServiceImp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class MetricController {

    private PermitationServiceImp permutationService;

    public MetricController(PermitationServiceImp permutationService) {
        this.permutationService = permutationService;
    }

    @PostMapping(value = "createMetric")
    public void createMetric(Long metric){
        permutationService.createLowMetric(metric);
    }
}
