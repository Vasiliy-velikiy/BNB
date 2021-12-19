package com.dataart.it.leaders.rest.api.service.impl;

import com.dataart.it.leaders.rest.api.service.RunJob;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Класс для регистрации и повторного запуска джобов */

@Service
public class RunJobImpl implements RunJob {
    JobLauncher launcher;
    Job job;
    public RunJobImpl() {
    }

    public RunJobImpl(JobLauncher launcher, Job job) {
        this.launcher = launcher;
        this.job = job;
    }

    @Override
    public void RunJob() {
        JobParametersBuilder builder=new JobParametersBuilder();
        JobParameters params=builder.addDate("timestamp", new Date()).toJobParameters();
        try {
            launcher.run(job,params);
        } catch (JobExecutionAlreadyRunningException e) {
            e.printStackTrace();
        } catch (JobRestartException e) {
            e.printStackTrace();
        } catch (JobInstanceAlreadyCompleteException e) {
            e.printStackTrace();
        } catch (JobParametersInvalidException e) {
            e.printStackTrace();
        }
    }
}
