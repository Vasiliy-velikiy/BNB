package com.dataart.it.leaders.rest.api.service.impl;

import com.dataart.it.leaders.rest.api.model.ServiceResponse;
import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Класс для записи ответов в бд*/
public class AliveWriter implements ItemWriter<ServiceResponse> {
    NamedParameterJdbcTemplate template;

    public AliveWriter(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public void write(List<? extends  ServiceResponse> list) throws Exception {
        for(ServiceResponse response:list){
            Map<String, Object> param=new HashMap<>();
            param.put("url",response.getUrl());
            param.put("code",response.getResponseCode());
            template.update("INSERT INTO RESPONSE VALUES (:url, :code)",param);
        }
    }
}
