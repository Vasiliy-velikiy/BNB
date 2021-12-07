package com.dataart.it.leaders.rest.api.configuration;

import com.dataart.it.leaders.rest.api.controller.UpdateMetricController;
import com.dataart.it.leaders.rest.api.service.MetricUpdate;
import com.dataart.it.leaders.rest.api.service.impl.MetricUpdateImpl;
import com.datart.it.leaders.core.lib.model.bound.BNBResult;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateMetricConfiguration {

    @Bean
    public BNBResult getMainState () {
        return new BNBResult();
    }

    @Bean
    public UpdateMetricController getMetricController() {
        return new UpdateMetricController(metricUpdate());
    }

    @Bean
    public MetricUpdate metricUpdate(){
        return new MetricUpdateImpl(getMainState());
    }
}
