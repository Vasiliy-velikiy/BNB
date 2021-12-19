package com.dataart.it.leaders.rest.api.service.impl;

import com.dataart.it.leaders.rest.api.model.Context;
import com.dataart.it.leaders.rest.api.service.PermutationService;
import com.datart.it.leaders.core.lib.model.bound.BNBResult;


import java.util.LinkedList;
import java.util.List;

public class PermitationServiceImp implements PermutationService {

    private final Context context;

    public Context getContext() {
        return context;
    }

    public PermitationServiceImp(Context context) {
        this.context= context;
    }

    @Override
    public void createInitialPermutation(List<Object> initilPermutation) {
        context.getBnbResult().getBranch().setSequence(initilPermutation);
    }

    @Override
    public void createLowMetric(Long metric) {
        context.getBnbResult().sethMetric(metric);
    }
}
