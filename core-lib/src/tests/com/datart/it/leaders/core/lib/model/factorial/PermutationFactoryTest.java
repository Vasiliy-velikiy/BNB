package com.datart.it.leaders.core.lib.model.factorial;

import com.datart.it.leaders.core.lib.service.PermutationFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class PermutationFactoryTest {

    @Test
    public void whenFN4020Then13542() {
        LinkedList<Integer> rslRearengment = new LinkedList<>(Arrays.asList(2, 4, 5, 3, 1));
        FactorialNumber fN = new FactorialNumber(new LinkedList<>(Arrays.asList(4, 0, 2, 0)));
        PermutationFactory permutationFactory = new PermutationFactory(new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5)));
        List<Object> rslOfFR = permutationFactory.getPermutation(fN);
        Assert.assertEquals(rslOfFR, rslRearengment);
    }

    @Test
    public void whenFN1Then13542() {
        LinkedList<Integer> rslRearengment = new LinkedList<>(Arrays.asList(2, 1, 3, 4, 5));
        FactorialNumber fN = new FactorialNumber(new LinkedList<>(Arrays.asList(1)));
        PermutationFactory permutationFactory = new PermutationFactory(new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5)));
        List<Object> rslOfFR = permutationFactory.getPermutation(fN);
        Assert.assertEquals(rslOfFR, rslRearengment);
    }
}