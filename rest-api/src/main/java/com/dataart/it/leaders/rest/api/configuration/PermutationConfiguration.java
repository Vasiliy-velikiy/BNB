package com.dataart.it.leaders.rest.api.configuration;

import com.dataart.it.leaders.rest.api.controller.PermutationController;
import com.dataart.it.leaders.rest.api.service.impl.PermitationServiceImp;
import com.datart.it.leaders.core.lib.model.bound.BNBResult;
import com.datart.it.leaders.core.lib.model.branch.Branch;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class PermutationConfiguration {



    @Bean
    public BNBResult getBnbresult(){
        return new BNBResult(new Branch(),0l,0l);
    }

    @Bean
    public PermitationServiceImp getInitialPermutation() {
        return new PermitationServiceImp(getBnbresult());
    }

    @Bean
    public PermutationController getControllerPermutation() {
        return new PermutationController(getInitialPermutation());
    }
}
