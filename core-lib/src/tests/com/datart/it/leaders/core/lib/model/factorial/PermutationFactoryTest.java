package com.datart.it.leaders.core.lib.model.factorial;

import com.datart.it.leaders.core.lib.service.PermutationFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class PermutationFactoryTest {

    @Test
    public void whenFN4020Then51423() {
        LinkedList<Integer> rslRearengment = new LinkedList<>(Arrays.asList(5, 1, 4, 2, 3));
        FactorialNumber fN = new FactorialNumber(new LinkedList<>(Arrays.asList(4, 0, 2, 0)));
        PermutationFactory permutationFactory = new PermutationFactory(new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5)));
        List<Object> rslOfFR = permutationFactory.getPermutationByNumber(fN);
        Assert.assertEquals(rslOfFR, rslRearengment);
    }

    @Test
    public void whenFN1Then12354() {
        LinkedList<Integer> rslRearengment = new LinkedList<>(Arrays.asList(1, 2, 3, 5, 4));
        FactorialNumber fN = new FactorialNumber(new LinkedList<>(Arrays.asList(1)));
        PermutationFactory permutationFactory = new PermutationFactory(new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5)));
        List<Object> rslOfFR = permutationFactory.getPermutationByNumber(fN);
        Assert.assertEquals(rslOfFR, rslRearengment);
    }

    @Test
    public void when51423ThenFN4020() {
        LinkedList<Object> rslRearengment = new LinkedList<>(Arrays.asList(5, 1, 4, 2, 3));
        FactorialNumber fN = new FactorialNumber(new LinkedList<>(Arrays.asList(4, 0, 2, 0)));
        PermutationFactory permutationFactory = new PermutationFactory(new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5)));
        FactorialNumber factorialNumber = permutationFactory.getNumberOfPermutation(rslRearengment);
        Assert.assertTrue(fN.equals(factorialNumber));
    }

    @Test
    public void when12354ThenFN1() {
        LinkedList<Object> rslRearengment = new LinkedList<>(Arrays.asList(1, 2, 3, 5, 4));
        FactorialNumber fN = new FactorialNumber(new LinkedList<>(Arrays.asList(1)));
        PermutationFactory permutationFactory = new PermutationFactory(new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5)));
        FactorialNumber factorialNumber = permutationFactory.getNumberOfPermutation(rslRearengment);
        Assert.assertTrue(fN.equals(factorialNumber));
    }
}