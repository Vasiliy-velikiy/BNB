package com.datart.it.leaders.core.lib.service;

import com.datart.it.leaders.core.lib.model.factorial.FactorialNumber;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PermutationFactory {
    final List<Object> originalValue;

    /**
     * Инициализация конструктора, List<Object>, в котором находятся элементы начальной перестановки
     *
     * @param originalValue
     */
    public PermutationFactory(List<Object> originalValue) {
        this.originalValue = originalValue;
    }


    /**
     * Получит перестановку по номеру
     * @param factorialNumber
     * @return
     */
    public List<Object> getPermutation(FactorialNumber factorialNumber) {
        List<Integer> number = factorialNumber.getValue();
        Object[] result = new Object[originalValue.size()];
        List<Integer> positionControl = IntStream.rangeClosed(0, originalValue.size() - 1).boxed().collect(Collectors.toList());

        for (Integer i = 0; i < originalValue.size(); i++) {
            int index = i < number.size() ? number.get(i) : 0;
            result[positionControl.remove(index)] = originalValue.get(i);
        }

        return Arrays.asList(result);
    }
}
