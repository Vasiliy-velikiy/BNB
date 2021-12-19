package com.dataart.it.leaders.rest.api.service.impl;

import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class ReaderAdress implements ItemReader<String> {
    private Properties properties;
    private Set<String> keys;
    private Iterator<String>iterator;


    @BeforeStep
    public void initStep() throws IOException {
        properties=new Properties();
        File file=new File("adress.properties");
        FileReader reader=new FileReader(file);
        properties.load(reader);
        keys=properties.stringPropertyNames();
        iterator=keys.iterator();
    }



    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
       String key= iterator.next();
       String retval=null;
       if(key!=null) {
         retval=properties.getProperty(iterator.next()); //когда итератор вернет null-значит дошел до конца
       }
        return retval;
    }
}
