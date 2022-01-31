package com.dataart.it.leaders.rest.api.service.impl;

import com.dataart.it.leaders.rest.api.model.ServiceResponse;
import org.springframework.batch.item.ItemWriter;

import java.util.List;
/**заглушка для степа записи */
public class DummyWriterForBounds  implements ItemWriter <ServiceResponse> {
    @Override
    public void write(List<? extends ServiceResponse> list) throws Exception {
        //Thread.sleep(100);
    }
}
