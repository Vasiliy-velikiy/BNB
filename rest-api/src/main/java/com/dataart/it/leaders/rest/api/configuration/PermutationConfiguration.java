package com.dataart.it.leaders.rest.api.configuration;

import com.dataart.it.leaders.rest.api.controller.PermutationController;
import com.dataart.it.leaders.rest.api.model.Context;
import com.dataart.it.leaders.rest.api.service.RunJob;
import com.dataart.it.leaders.rest.api.service.impl.PermitationServiceImp;
import com.dataart.it.leaders.rest.api.service.impl.RunJobImpl;
import com.datart.it.leaders.core.lib.model.bound.BNBResult;
import com.datart.it.leaders.core.lib.model.branch.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PermutationConfiguration {

    @Autowired
    RunJob runJob;

    //задаем начальные параметры лоу хай метрик как 0
    @Bean
    public BNBResult getBnbresult() {
        return new BNBResult(new Branch(), 0l, 0l);
    }

    //решили что результаты обсчета(лоу хай метрик будем хранить в поджо классе Context)
    @Bean
    public Context getContext() {
        return Context.getInstance(getBnbresult());
    }

    @Bean
    public PermitationServiceImp getInitialPermutation() {
        return new PermitationServiceImp(getContext());
    }

    //контроллер принимает начальную перестановку и бин который запускает работу(как только пришла первоначальня перестановка-это тригер для запуска процесса обсчета, передачи данных другим вычислителям)
    @Bean
    public PermutationController getControllerPermutation() throws Exception {
        return new PermutationController(getInitialPermutation(), runJob);
    }
}
