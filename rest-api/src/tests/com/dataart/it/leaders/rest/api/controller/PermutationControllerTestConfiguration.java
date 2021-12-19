package com.dataart.it.leaders.rest.api.controller;

import com.dataart.it.leaders.rest.api.model.Context;
import com.dataart.it.leaders.rest.api.service.impl.PermitationServiceImp;
import com.dataart.it.leaders.rest.api.service.impl.RunJobImpl;
import com.datart.it.leaders.core.lib.model.bound.BNBResult;
import com.datart.it.leaders.core.lib.model.branch.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableAutoConfiguration
public class PermutationControllerTestConfiguration implements WebMvcConfigurer {

    @Autowired
    RunJobImpl runJob;

    @Bean
    public BNBResult getBnbresult(){
        return new BNBResult(new Branch(),0l,0l);
    }

    @Bean
    public Context getContext(){
        return new Context(getBnbresult());
    }

    @Bean
    public PermitationServiceImp getInitialPermutation() {
        return new PermitationServiceImp(getContext());
    }


    @Bean
    public PermutationController getControllerPermutation() throws Exception {
        return new PermutationController(getInitialPermutation(),runJob);
    }



}
