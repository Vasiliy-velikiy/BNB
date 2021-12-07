package com.dataart.it.leaders.rest.api.controller;

import com.dataart.it.leaders.rest.api.service.MetricUpdate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateMetricController {

    private MetricUpdate metricUpdate;

    public UpdateMetricController() {
    }

    public UpdateMetricController(MetricUpdate metricUpdate) {
        this.metricUpdate = metricUpdate;
    }

    @PostMapping(value = "postMetric")
    public void postMetric(Long metric) {
        metricUpdate.setMetric(metric);
    }
}
