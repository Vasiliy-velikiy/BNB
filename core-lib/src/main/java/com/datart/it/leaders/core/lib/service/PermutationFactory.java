package com.datart.it.leaders.core.lib.service;

import com.datart.it.leaders.core.lib.model.factorial.FactorialNumber;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PermutationFactory {

    private final List<Object> originalValue;


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
    public List<Object> getPermutationByNumber(FactorialNumber factorialNumber) {
        List<Object> list = originalValue.stream().collect(Collectors.toList());
        List<Integer> number = factorialNumber.getValue();
        number.add(0);
        List<Object> result = new LinkedList<>();
        for (Integer i = 0; i < originalValue.size(); i++) {
            int index = number.size() < list.size() ?  0:number.remove(0);
            result.add(list.remove(index));
        }
        return result;
    }

    /**
     * Получит номер перестановки
     * @param permutation
     * @return
     */
    public FactorialNumber getNumberOfPermutation(List<Object> permutation) {
        List<Object> list = originalValue.stream().collect(Collectors.toList());
        List<Integer>result = new LinkedList<>();
        for (Integer i = 0; i < originalValue.size()-1; i++) {
            int index = list.indexOf(permutation.remove(0));
            list.remove(index);
            result.add(index);
        }
        while(!result.isEmpty() && result.get(0)==0){
            result.remove(0);
        }
        return new FactorialNumber(result);
    }


}
