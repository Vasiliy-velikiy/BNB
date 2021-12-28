package com.dataart.it.leaders.rest.api.service.impl;

import com.dataart.it.leaders.rest.api.model.ServiceResponse;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
/**
 * Класс для получение ответа от вычислителя-если код 200 значит живой */
public class HealhProcessor implements ItemProcessor<String, ServiceResponse> {


    /**адрес который принимает (healthCheck) как описано в контроллере  */
    @Override
    public ServiceResponse process(String url){
        RestTemplate rt=new RestTemplate();
        Integer code;
        try {
            ResponseEntity<String> response= rt.getForEntity(url, String.class);
            code=response.getStatusCodeValue();
        }catch( RestClientException ex){
            code=400;
        }
        return new ServiceResponse(url,code);

    }
}
