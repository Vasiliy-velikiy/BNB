package com.datart.it.leaders.core.lib.model.factorial;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;


public class FactorialRecoveryTest {

    @Test
    public void whenFN4020Then13542() {
        LinkedList<Integer> rslRearengment = new LinkedList<>(Arrays.asList(1, 3, 5, 4, 2));
        FactorialNumber fN = new FactorialNumber(new LinkedList<>(Arrays.asList(4, 0, 2, 0)));
        FactorialRecovery factorialRecovery = new FactorialRecovery(new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5)));
        LinkedList<Integer> rslOfFR = factorialRecovery.recoveryByFactorialNumber(fN);
        Assert.assertEquals(rslRearengment, rslOfFR);
    }

    @Test
    public void whenFN1Then13542() {
        LinkedList<Integer> rslRearengment = new LinkedList<>(Arrays.asList(4, 5, 3, 2, 1));
        FactorialNumber fN = new FactorialNumber(new LinkedList<>(Arrays.asList(1)));
        FactorialRecovery factorialRecovery = new FactorialRecovery(new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5)));
        LinkedList<Integer> rslOfFR = factorialRecovery.recoveryByFactorialNumber(fN);
        Assert.assertEquals(rslRearengment, rslOfFR);
    }
}