package com.dataart.it.leaders.rest.api.configuration;

import com.dataart.it.leaders.rest.api.controller.HealthChekController;
import com.dataart.it.leaders.rest.api.service.HealthCheck;
import com.dataart.it.leaders.rest.api.service.impl.HealthCheckImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HealthCheckConfiguration {

    @Bean
    public HealthChekController getController(){
        return new HealthChekController(getServiceImpl());
    }

    @Bean
    public HealthCheck getServiceImpl(){
        return new HealthCheckImpl();
    }


}
