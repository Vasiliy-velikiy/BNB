package com.datart.it.leaders.core.lib.model.exception;

public class FactorialNumberException extends Exception {
    private int number;
    public int getNumber(){return number;}
    public FactorialNumberException(String message, int num){

        super(message);
        number=num;
    }
}
