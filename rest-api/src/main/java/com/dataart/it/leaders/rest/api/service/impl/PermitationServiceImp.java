package com.dataart.it.leaders.rest.api.service.impl;

import com.dataart.it.leaders.rest.api.service.PermutationService;
import com.datart.it.leaders.core.lib.model.bound.BNBResult;


import java.util.LinkedList;
import java.util.List;

public class PermitationServiceImp implements PermutationService {
    private final BNBResult bnbResult;

    public PermitationServiceImp(BNBResult bnbResult) {
        this.bnbResult = bnbResult;
    }

    @Override
    public void createInitialPermutation(List<Object> initilPermutation) {
        bnbResult.getBranch().setSequence(initilPermutation);
    }

    @Override
    public void createLowMetric(Long metric) {
        bnbResult.sethMetric(metric);
    }
}
