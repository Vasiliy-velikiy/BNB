package com.dataart.it.leaders.rest.api.service.impl;

import com.dataart.it.leaders.rest.api.service.HealthCheck;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class HealthCheckImpl implements HealthCheck {
    final static String message = "Server is alive!";

    @Override
    public String checkHealth() {
        return message;
    }

}
