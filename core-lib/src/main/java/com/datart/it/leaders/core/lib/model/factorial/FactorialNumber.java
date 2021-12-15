package com.datart.it.leaders.core.lib.model.factorial;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FactorialNumber {
    /**
     * факториальное число,хранится в структуре данных LinkedList
     */
    private List<Integer> value;

    /**
     * факториальное число, инициализируется в кострукторе,в нем так же находится проверка ,что число в фк системе счисления
     * int rankFactorial - инициализируется 1, разряд последнего елемента в списке.
     * в цикле сравниваем,что значение элемента не выходит за разрядность его числа,если выходит число не факториальное
     *
     * @param inNumber
     */
    public FactorialNumber(List<Integer> inNumber) {
        //переворачиваем массив
        boolean isBadFactor = IntStream.rangeClosed(1, inNumber.size())
                .anyMatch(i -> {
                    return inNumber.get(inNumber.size() - i) >= i + 1;
                });
        if (isBadFactor) {
            throw new IllegalArgumentException("Wrong factor array");
        }
        this.value = inNumber;
        Collections.reverse(this.value);
    }

    public List<Integer> getValue() {
        List<Integer> retval = value.stream()
                .collect(Collectors.toList());
        Collections.reverse(retval);
        return retval;
    }

    /**
     * сравниваем списки на идентичность
     *
     * @param factorialNumber
     * @return false если числа не соответствуют
     */
    public boolean equals(FactorialNumber factorialNumber) {
        return value.equals(factorialNumber.value);
    }

    public FactorialNumber add(FactorialNumber factorialNumber) {
        List<Integer> firstValue = new LinkedList<>(value);
        List<Integer> secondValue = new LinkedList<>(factorialNumber.value);
        List<Integer> result = new LinkedList<>();
        Integer carry = 0;
        Integer i = 1;
        while ((firstValue.size() > 0) || (secondValue.size() > 0) || (carry != 0)) {
            Integer first = (firstValue.size() > 0) ? firstValue.remove(0) : 0;
            Integer second = (secondValue.size() > 0) ? secondValue.remove(0) : 0;
            Integer sum = first + second + carry;
            carry = sum > i ? 1 : 0;
            result.add(sum > i ? sum - (i + 1) : sum);
            i++;
        }
        Collections.reverse(result);
        return new FactorialNumber(result);
    }

    public FactorialNumber sub(FactorialNumber factorialNumber) {
        List<Integer> firstValue = new LinkedList<>(value);
        List<Integer> secondValue = new LinkedList<>(factorialNumber.value);
        List<Integer> result = new LinkedList<>();
        Integer decreaseByOne = 0;
        Integer i = 1;
        while ((firstValue.size() > 0) || (secondValue.size() > 0) || (decreaseByOne != 0)) {
            Integer first = (firstValue.size() > 0) ? firstValue.remove(0) : 0;
            Integer second = (secondValue.size() > 0) ? secondValue.remove(0) : 0;
            Integer subtraction = first - second + decreaseByOne;
            decreaseByOne = subtraction < 0 ? -1 : 0;
            result.add(subtraction < 0 ? (i + 1) + subtraction : subtraction);
            i++;
        }
        Collections.reverse(result);
        return new FactorialNumber(result);
    }

    public FactorialNumber inc() {
        return this.add(new FactorialNumber(new LinkedList<>(Arrays.asList(1))));
    }

    public FactorialNumber dec() {
        return this.sub(new FactorialNumber(new LinkedList<>(Arrays.asList(1))));
    }
}
