package com.dataart.it.leaders.rest.api.service.impl;

import com.dataart.it.leaders.rest.api.service.MetricUpdate;
import com.datart.it.leaders.core.lib.model.bound.BNBResult;
/**Обновление метрики*/
public class MetricUpdateImpl implements MetricUpdate {

    private BNBResult result;

    public MetricUpdateImpl() {
    }

    public MetricUpdateImpl(BNBResult result) {
        this.result = result;
    }

    @Override
    public void setMetric(Long metric) {
        result.setlMetric(metric);
    }


}
