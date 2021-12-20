package com.dataart.it.leaders.rest.api.service.impl;

import com.dataart.it.leaders.rest.api.model.Context;
import com.dataart.it.leaders.rest.api.model.ServiceResponse;
import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Класс для записи ответов на запросы в бд или в класс Context*/
public class AliveWriter implements ItemWriter<ServiceResponse> {
   // NamedParameterJdbcTemplate template;
    Context context;

   // public AliveWriter(NamedParameterJdbcTemplate template) { this.template = template; }

    public AliveWriter(Context context) {
        this.context = context;
    }

    @Override
    public void write(List<? extends  ServiceResponse> list) throws Exception {
        for(ServiceResponse response:list){
            //вариант если бы записывали в бд
            /*
            Map<String, Object> param=new HashMap<>();
            param.put("url",response.getUrl());
            param.put("code",response.getResponseCode());
            template.update("INSERT INTO RESPONSE VALUES (:url, :code)",param);
             */
            //вариант записи в поджо класс
            context.getMapAlive().put("url", response.getUrl());
            context.getMapAlive().put("code",response.getResponseCode());
        }
    }
}
