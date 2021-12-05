package com.dataart.it.leaders.rest.api.service.impl;

import com.dataart.it.leaders.rest.api.service.PermutationService;
import com.datart.it.leaders.core.lib.model.bound.BNBResult;
import com.datart.it.leaders.core.lib.service.PermutationFactory;

import java.util.List;

public class PermitationServiceImp implements PermutationService {
    private PermutationFactory permutationFactory;
    private BNBResult bnbResult;

    public PermitationServiceImp() {
    }

    public PermitationServiceImp(PermutationFactory permutationFactory) {
        this.permutationFactory = permutationFactory;
    }

    public PermitationServiceImp(BNBResult bnbResult) {
        this.bnbResult = bnbResult;
    }


    @Override
    public List getInitialPermutation() {
        return permutationFactory.getOriginalValue();

    }



    @Override
    public Long getHighMetric() {
        return bnbResult.gethMetric();
    }

    @Override
    public Long getLowMetric() {
        return bnbResult.getlMetric();
    }
}
