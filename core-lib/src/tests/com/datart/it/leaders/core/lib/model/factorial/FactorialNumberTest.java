package com.datart.it.leaders.core.lib.model.factorial;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

public class FactorialNumberTest {

    @Test
    public void whenSum4321to321() {
        FactorialNumber fN1 = new FactorialNumber(new LinkedList<>(Arrays.asList(4, 3, 2, 1)));
        FactorialNumber fN2 = new FactorialNumber(new LinkedList<>(Arrays.asList(3, 2, 1)));
        FactorialNumber fNRsl = new FactorialNumber(new LinkedList<>(Arrays.asList(1, 0, 3, 2, 0)));
        Assert.assertEquals( fN1.addToFactorialNumberAnotherNumber(fN2).inNumber , fNRsl.inNumber);
    }

    @Test
    public void whenSum4020to321() {
        FactorialNumber fN1 = new FactorialNumber(new LinkedList<>(Arrays.asList(4, 0, 2, 0)));
        FactorialNumber fN2 = new FactorialNumber(new LinkedList<>(Arrays.asList(3, 2, 1)));
        FactorialNumber fNRsl = new FactorialNumber(new LinkedList<>(Arrays.asList(1, 0, 0, 1, 1)));
        Assert.assertEquals( fN1.addToFactorialNumberAnotherNumber(fN2).inNumber , fNRsl.inNumber);
    }

    @Test
    public void whenIncreaseByOne() {
        FactorialNumber fN1 = new FactorialNumber(new LinkedList<>(Arrays.asList(4, 0, 2, 1)));
        FactorialNumber fNRsl = new FactorialNumber(new LinkedList<>(Arrays.asList(4, 1, 0, 0)));
        Assert.assertEquals( fN1.increaseByOne().inNumber , fNRsl.inNumber);
    }

    @Test
    public void whenRemove1001to0110() {
        FactorialNumber fN1 = new FactorialNumber(new LinkedList<>(Arrays.asList(1, 0, 0, 1)));
        FactorialNumber fNR2 = new FactorialNumber(new LinkedList<>(Arrays.asList(0, 1, 1, 0)));
        FactorialNumber fNRsl = new FactorialNumber(new LinkedList<>(Arrays.asList(0, 2, 2, 1)));
        Assert.assertEquals( fN1.removeFromFactorialNumberAnotherNumber(fNR2).inNumber , fNRsl.inNumber);
    }

    @Test
    public void whenRemove1000to10() {
        FactorialNumber fN1 = new FactorialNumber(new LinkedList<>(Arrays.asList(1, 0, 0, 0)));
        FactorialNumber fNR2 = new FactorialNumber(new LinkedList<>(Arrays.asList(0, 0, 1, 0)));
        FactorialNumber fNRsl = new FactorialNumber(new LinkedList<>(Arrays.asList(0, 3, 2, 0)));
        Assert.assertEquals( fN1.removeFromFactorialNumberAnotherNumber(fNR2).inNumber , fNRsl.inNumber);
    }
}