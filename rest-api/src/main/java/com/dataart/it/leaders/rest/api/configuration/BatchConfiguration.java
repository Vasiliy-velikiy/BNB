package com.dataart.it.leaders.rest.api.configuration;


import com.dataart.it.leaders.rest.api.controller.PermutationController;
import com.dataart.it.leaders.rest.api.model.Context;
import com.dataart.it.leaders.rest.api.model.ServiceResponse;
import com.dataart.it.leaders.rest.api.service.RunJob;
import com.dataart.it.leaders.rest.api.service.impl.*;
import com.datart.it.leaders.core.lib.model.bound.BNBResult;
import com.datart.it.leaders.core.lib.model.branch.Branch;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.support.MapJobRegistry;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.core.repository.support.SimpleJobRepository;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.jsr.item.ItemReaderAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.util.FileCopyUtils;

import java.io.InputStreamReader;
import java.io.Reader;

@Configuration
public class BatchConfiguration {


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
        return new PermutationController(getInitialPermutation(), getRunJobImpl());
    }

    //бин для запуска джобы-запуск только с помощью лаунчера и самой джлбы в который помещены шаги (см бин выше)
    @Bean
    public RunJob getRunJobImpl() throws Exception {
        return new RunJobImpl(getLouncher(),getJobComputedMetric());
    }




//1) создать бд (dataSource) для job репозитария на основе h2
    //коннект к БД, инициализируем бд скриптом
    @Bean
    public DriverManagerDataSource getDataSourse(){
        DriverManagerDataSource dm=new DriverManagerDataSource();
        dm.setDriverClassName("org.h2.Driver");
        dm.setUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;");
        dm.setUsername("sa");
        dm.setPassword("");
        return dm;
    }

    //чтобы гонять запросы
    public NamedParameterJdbcTemplate getTemplate(){
        return new NamedParameterJdbcTemplate(getDataSourse());
    }

//2) создаем менеджер транзакций  -нам нужна поддержка транзакций (атомарность всех операций)
    @Bean
    public PlatformTransactionManager getBatchTransactionManager(){
        return new DataSourceTransactionManager(getDataSourse());
    }

//3 создание JobRepository (прослойка над бд)-возможность спрингбача делать операции с репозитарием и зависит от транзак менеджера и датасоурса
    @Bean
    public JobRepository getJobRepository() throws Exception {
        ResourceLoader loader=new DefaultResourceLoader();
        Resource resource = loader.getResource("org/springframework/batch/core/schema-drop-h2.sql"); //считывание внутреннего ресурса с помощью класса загрузчика
        Reader reader=new InputStreamReader(resource.getInputStream());//считывание ресурса из пути на строчку выге
        String sql = FileCopyUtils.copyToString(reader);//копирование содержимого файла куда угодно-в данном случае в переменную стринга
        getTemplate().getJdbcTemplate().execute(sql); // полный функц Jdbc не нужен, чтобы выполнить запрос без параметров

        //теперь поднимаем бд
        resource = loader.getResource("org/springframework/batch/core/schema-h2.sql");
        reader=new InputStreamReader(resource.getInputStream());
        sql = FileCopyUtils.copyToString(reader);
        getTemplate().getJdbcTemplate().execute(sql);

        getTemplate().getJdbcTemplate().execute("CREATE TABLE RESPONSE (url VARCHAR(255), code NUMBER)");


        JobRepositoryFactoryBean factory=new JobRepositoryFactoryBean();
        factory.setTransactionManager(getBatchTransactionManager());
        factory.setIsolationLevelForCreate("ISOLATION_REPEATABLE_READ"); //когда работают несколько джобов одновременно- они не перезаписывают данные
        factory.setTablePrefix("BATCH_");
        factory.setDataSource(getDataSourse());
        factory.setDatabaseType("H2");

        return factory.getObject();
    }


    @Bean
    public JobBuilderFactory getJobFactory() throws Exception {
        return new JobBuilderFactory(getJobRepository());
    }
    @Bean
    public StepBuilderFactory getStepFactory() throws Exception {
        return new StepBuilderFactory(getJobRepository(), getBatchTransactionManager());
    }


    @Bean
    public JobLauncher getLouncher() throws Exception {
        SimpleJobLauncher JobLauncher = new SimpleJobLauncher();
        JobLauncher.setJobRepository(getJobRepository());
        JobLauncher.setTaskExecutor(new SimpleAsyncTaskExecutor());
        JobLauncher.afterPropertiesSet();
        return JobLauncher;
    }


    //бин процессора на вычисление лоу хай метрики
    @Bean
    public ItemProcessor<BNBResult,BNBResult> getComputeMetric(){
 return new ProccesorForComputed(getContext());
}



    //  создание  степов
        //Обсчет первоначальной перестановки(high, low metric)
    @Bean
    public Step getStepCompute() throws Exception {
        return getStepFactory().get("step1")
                .<BNBResult,BNBResult>chunk(1)
                .processor(getComputeMetric())
                .build();
    }
        //Опросить health check  у помогающих вычислителей

    @Bean
    public ItemReader<String> getAdressReader(){
        return new ReaderAdress();
    }
    @Bean
    public ItemProcessor<String, ServiceResponse>getHealhProcessor(){
        return new HealhProcessor();
    }

    @Bean
    public ItemWriter<ServiceResponse> getAddressWriter(){
        return new AliveWriter(getContext());
    }

        @Bean
        public Step getStepHealh() throws Exception {
            return getStepFactory().get("step2")
                    .<String, ServiceResponse>chunk(1)
                    .reader(getAdressReader())
                    .processor(getHealhProcessor())
                    .writer(getAddressWriter())
                    .build();
        }

        //отправка перестановки помогающим вычислителям

    @Bean
    public ItemReader<String> getResponceAndAdressReader(){
        return new ResponseAndAdressReader();
    }

    @Bean
    public ItemProcessor  getClientForDispatch(){
        return new ClientForDispatchProcessor();
    }

    @Bean
    public Step getStepPostPermut() throws Exception {
        return getStepFactory().get("step3")
                .<String, ServiceResponse>chunk(1)
                .reader(getResponceAndAdressReader())
                .processor(getClientForDispatch())
                .build();
    }


    //создание JOB -1 для главного вычислителя (первоначальная инициализация)
    @Bean
    public Job getJobComputedMetric() throws Exception {
        return getJobFactory()
                .get("Job1")
                .start(getStepCompute())
                .next(getStepHealh())
                .next(getStepPostPermut())
                .build();
                
    }

}
