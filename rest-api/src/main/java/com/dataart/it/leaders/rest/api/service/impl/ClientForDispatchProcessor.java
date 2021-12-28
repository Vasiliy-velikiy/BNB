package com.dataart.it.leaders.rest.api.service.impl;

import com.dataart.it.leaders.rest.api.model.Context;
import com.datart.it.leaders.core.lib.model.bound.BNBResult;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Класс для отправки всем живым вычислителям начальную перестановку*/
public class ClientForDispatchProcessor implements ItemProcessor<String,BNBResult>{
    Context context;

    @Override
    public BNBResult   process(String url) throws Exception {
        //объект для отправки перовначальной перестановки
        RestTemplate restTemplate=new RestTemplate();
        // объект ответа=ему присваивается значение результата выполнения пост запроса (в параметрах адрес, передаваемый объект, тип возвращаемого значения)
        ResponseEntity<String> response = restTemplate.postForEntity(url, context.getBnbResult(),String.class);
        //мы должны знать успешно прошла отправка или нет -тогда возвращаем код ответа, но я пока не хочу
        return null;
    }
}
