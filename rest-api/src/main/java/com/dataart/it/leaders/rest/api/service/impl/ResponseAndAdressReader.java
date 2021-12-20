package com.dataart.it.leaders.rest.api.service.impl;

import com.dataart.it.leaders.rest.api.model.Context;
import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Класс для считывание адресов и кодов-ответов из Context*/
public class ResponseAndAdressReader implements ItemReader<String> {
    Context context;
    private Set<String> aliveAdress;//набор живых адресов
    private Iterator<String>iterator;

    //добавление всех живых адресов в набор
    @BeforeStep
    public void initStep() throws IOException {
        for (Map.Entry<String, Integer> entry : context.getMapAlive().entrySet()) {
            if(entry.getValue()==200)   aliveAdress.add(entry.getKey());
        }
        iterator=aliveAdress.iterator();
    }


    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        return iterator.next();

    }
 }

