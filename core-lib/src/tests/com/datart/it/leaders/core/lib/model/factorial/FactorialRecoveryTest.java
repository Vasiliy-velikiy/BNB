package com.datart.it.leaders.core.lib.model.factorial;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FactorialRecoveryTest {

    @Test
    public void whenFN4020Then13542() {
        List<Integer> linkedListInit = List.of(4, 0, 2, 0);
        List<Integer> arrayListInit = List.of(1, 2, 3, 4, 5);
        List<Integer> rslarrayListInit = List.of(1, 3, 5, 4, 2);
        LinkedList<Integer> factorialNumber = new LinkedList<>(linkedListInit);
        ArrayList<Integer> firstRearengment = new ArrayList<>(arrayListInit);
        ArrayList<Integer> rslRearengment = new ArrayList<>(rslarrayListInit);
        FactorialNumber fN = new FactorialNumber(factorialNumber);
        FactorialRecovery factorialRecovery = new FactorialRecovery(firstRearengment);
        ArrayList<Integer> rslOfFR = factorialRecovery.recoveryByFactorialNumber(fN);
        Assert.assertEquals(rslRearengment, rslOfFR);
    }

}