package com.dataart.it.leaders.rest.api.service.impl;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
/**заглушка для степа чтения */
public class DummyReaderForBounds implements ItemReader<String> {


    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        return null;
    }
}
