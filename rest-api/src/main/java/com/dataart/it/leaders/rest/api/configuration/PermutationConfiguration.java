package com.dataart.it.leaders.rest.api.configuration;

import com.dataart.it.leaders.rest.api.controller.MetricController;
import com.dataart.it.leaders.rest.api.controller.PermutationController;
import com.dataart.it.leaders.rest.api.service.impl.PermitationServiceImp;
import com.datart.it.leaders.core.lib.model.bound.BNBResult;
import com.datart.it.leaders.core.lib.model.branch.Branch;
import com.datart.it.leaders.core.lib.service.PermutationFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration
public class PermutationConfiguration {


    @Bean
    @Scope("prototype")
    public BNBResult getBnbresult(){
        return new BNBResult();
    }

    @Bean
    @Scope("prototype")
    public Branch getBranch(){
        return new Branch();
    }

    @Bean
    public PermitationServiceImp getInitialPermutation() {
        return new PermitationServiceImp(getBnbresult(),getBranch());
    }

   /* @Bean
    public PermitationServiceImp getInitialPermutation() {
        return new PermitationServiceImp(getBnbresult());
    }

    @Bean
    public PermitationServiceImp getInitialPermutation1() {
        return new PermitationServiceImp(getBranch());
    }*/

    @Bean
    public PermutationController getControllerPermutation() {
        return new PermutationController(getInitialPermutation());
    }

    @Bean
    public MetricController getMetricController() {
        return new MetricController(getInitialPermutation());
    }

}
