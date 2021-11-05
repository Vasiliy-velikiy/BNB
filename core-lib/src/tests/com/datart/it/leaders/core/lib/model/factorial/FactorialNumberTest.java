package com.datart.it.leaders.core.lib.model.factorial;

import com.datart.it.leaders.core.lib.model.exception.FactorialNumberException;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class FactorialNumberTest {


                    //!!!!!!!!
    @Test //(expected = FactorialNumberException.class)   //этот флаг idea не видит и выдает ошибку Expected exception: com.datart.it.leaders.core.lib.model.exception.FactorialNumberException
    public void addValue() throws FactorialNumberException {   //idea сама заставляет здесь устанавливать сигнатуру с исключением
                                                                //Error:(68, 39) java: unreported exception com.datart.it.leaders.core.lib.model.exception.FactorialNumberException; must be caught or declared to be thrown
        FactorialNumber factorialNumber=new FactorialNumber();
        factorialNumber.setCoeffNumber(new LinkedList<>(Arrays.asList(1,0)));
        factorialNumber.addValue(new FactorialNumber(new LinkedList<>(Arrays.asList(3,2,1))));
        List arr = Arrays.stream(new int[]{1, 0, 0, 1})
                .boxed()
                .collect(Collectors.toList());
        assertEquals(factorialNumber.getCoeffNumber(),arr);
    }


    @Test
    public void addOne() throws FactorialNumberException {

        FactorialNumber factorialNumber=new FactorialNumber(new LinkedList<>(Arrays.asList(1,0)));
        factorialNumber.addOne();
        List arr = Arrays.stream(new int[]{1, 1})
                .boxed()
                .collect(Collectors.toList());
        assertEquals(factorialNumber.getCoeffNumber(),arr);
    }


    @Test
    public void subOne() throws FactorialNumberException {
        FactorialNumber factorialNumber=new FactorialNumber(new LinkedList<>(Arrays.asList(1,0,0,0)));
        factorialNumber.subOne();
        List arr = Arrays.stream(new int[]{3,2,1})
                .boxed()
                .collect(Collectors.toList());
        assertEquals(factorialNumber.getCoeffNumber(),arr);

    }

    @Test
    public void subValue() throws FactorialNumberException {
        FactorialNumber factorialNumber=new FactorialNumber();
        factorialNumber.setCoeffNumber(new LinkedList<>(Arrays.asList(1,0,0,1)));
        factorialNumber.subValue(new FactorialNumber(new LinkedList<>(Arrays.asList(1,0))));
        List arr = Arrays.stream(new int[]{3, 2, 1})
                .boxed()
                .collect(Collectors.toList());
        assertEquals(factorialNumber.getCoeffNumber(),arr);
    }

    //должна вылететь ошибка при создании нефакториального числа
    @Test (expected = FactorialNumberException.class)
    public void subValue1() throws FactorialNumberException {
        FactorialNumber factorialNumber=new FactorialNumber();
        factorialNumber.setCoeffNumber(new LinkedList<>(Arrays.asList(1,0,0,5)));  //нефакториальное число
        factorialNumber.subValue(new FactorialNumber(new LinkedList<>(Arrays.asList(1,0))));
        List arr = Arrays.stream(new int[]{3, 2, 1})
                .boxed()
                .collect(Collectors.toList());
        assertEquals(factorialNumber.getCoeffNumber(),arr);
    }
}