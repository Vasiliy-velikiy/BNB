package com.dataart.it.leaders.rest.api.service.impl;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class DummyWriter implements ItemWriter {
    @Override
    public void write(List list) throws Exception {
       // Thread.sleep(100);
    }
}
