package com.dataart.it.leaders.rest.api.service.impl;

import com.dataart.it.leaders.rest.api.model.ServiceResponse;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class HealhProcessor implements ItemProcessor<String, ServiceResponse> {
    @Override
    public ServiceResponse process(String url) throws Exception {
        RestTemplate template=new RestTemplate();
        ResponseEntity<String>responseEntity=template.getForEntity(url,String.class);
        return  new ServiceResponse(url,responseEntity.getStatusCode().value());
    }
}
