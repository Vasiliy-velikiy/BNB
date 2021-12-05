package com.dataart.it.leaders.rest.api.configuration;

import com.dataart.it.leaders.rest.api.controller.PermutationController;
import com.dataart.it.leaders.rest.api.service.impl.PermitationServiceImp;
import com.datart.it.leaders.core.lib.model.bound.BNBResult;
import com.datart.it.leaders.core.lib.service.PermutationFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration
public class PermutationConfiguration {


    @Bean
    public PermutationFactory getPermutationFactory() {
        return new PermutationFactory(new ArrayList<>(Arrays.asList(1,2,3)));
    }

    @Bean
    public PermitationServiceImp getInitialPermutation() {
        return new PermitationServiceImp(getPermutationFactory());
    }

    @Bean
    public BNBResult getBnbresult(){
        return new BNBResult();
    }

    @Bean
    public PermutationController getControllerPermutation() {
        return new PermutationController(getInitialPermutation(),getBnbresult());
    }

   /* @Bean
    public PermutationController getControllerPermutation() {
        return new PermutationController(getInitialPermutation());
    }*/

    /* @Bean
    public PermutationController getControllerMetric(){
        return new PermutationController(getBnbresult());
    }*/


}
