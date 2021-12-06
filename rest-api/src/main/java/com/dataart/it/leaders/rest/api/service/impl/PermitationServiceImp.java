package com.dataart.it.leaders.rest.api.service.impl;

import com.dataart.it.leaders.rest.api.service.PermutationService;
import com.datart.it.leaders.core.lib.model.bound.BNBResult;
import com.datart.it.leaders.core.lib.model.branch.Branch;
import com.datart.it.leaders.core.lib.service.PermutationFactory;

import java.util.LinkedList;
import java.util.List;

public class PermitationServiceImp implements PermutationService {
   private BNBResult bnbResult;
   private Branch branch;

    public PermitationServiceImp(BNBResult bnbResult) {
        this.bnbResult = bnbResult;
    }

    public PermitationServiceImp(Branch branch) {
        this.branch = branch;
    }


    @Override
    public void createInitialPermutation(List initilPermutation) {
      branch.setSequence(initilPermutation);
    }

    @Override
    public void createLowMetric(Long metric) {
        bnbResult.sethMetric(metric);
    }
}
