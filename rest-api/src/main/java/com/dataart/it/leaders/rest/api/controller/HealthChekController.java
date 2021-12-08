package com.dataart.it.leaders.rest.api.controller;

import com.dataart.it.leaders.rest.api.service.HealthCheck;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthChekController {

    private HealthCheck healthService;

    public HealthChekController() {
    }

    public HealthChekController(HealthCheck healthService) {
        this.healthService = healthService;
    }

    @GetMapping(value="healthCheck")
    public String healthCheck(){
        return healthService.checkHealth();
    }
}
