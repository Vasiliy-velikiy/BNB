package com.dataart.it.leaders.rest.api.controller;


import com.dataart.it.leaders.rest.api.service.RunJob;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**Запуск джобов которые используются в спрингбаче*/
@RestController
public class JobRunnerController {
   RunJob runner;

    public JobRunnerController() {
    }

    public JobRunnerController(RunJob runner) {
        this.runner = runner;
    }

    @GetMapping(value = "runJob")
    public void run(){
        runner.RunJob();
    }
}