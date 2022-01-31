package com.dataart.it.leaders.rest.api.service.impl;

import com.dataart.it.leaders.rest.api.service.HealthCheck;
import org.springframework.stereotype.Service;

/**Живой, не живой сервис */
@Service
public class HealthCheckImpl implements HealthCheck {
    final static String message = "Server is alive!";

    @Override
    public String checkHealth() {
        return message;
    }

}