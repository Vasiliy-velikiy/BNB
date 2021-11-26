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
    LinkedList<Integer> inNumber;

    /**
     * факториальное число, инициализируется в кострукторе,в нем так же находится проверка ,что число в фк системе счисления
     * int rankFactorial - инициализируется 1, разряд последнего елемента в списке.
     * в цикле сравниваем,что значение элемента не выходит за разрядность его числа,если выходит число не факториальное
     *
     * @param inNumber
     */
    public FactorialNumber(LinkedList<Integer> inNumber) {
        //переворачиваем массив
        boolean isBadFactor = IntStream.rangeClosed(1, inNumber.size())
                .anyMatch(i -> {
                    return inNumber.get(inNumber.size() - i) >= i+1;
                });
        if (isBadFactor) {
            throw new IllegalArgumentException("Wrong factor array");
        }
        this.inNumber = inNumber;
        Collections.reverse(this.inNumber);
    }

    public List<Integer> getInNumber() {
        List<Integer> retval = inNumber.stream()
                .collect(Collectors.toList());
        Collections.reverse(retval);
        return retval;
    }

        /**
         * сравниваем списки на идентичность
         * @param factorialNumber
         * @return false если числа не соответствуют
         */
        public boolean equals (FactorialNumber factorialNumber){
            return inNumber.equals(factorialNumber.inNumber);
        }

    public FactorialNumber addToFactorialNumberAnotherNumber (FactorialNumber factorialNumber) {
            LinkedList<Integer> result = new LinkedList<>();
            Integer carry = 0;
            Integer i = 1;
            while ((inNumber.size() > 0) || (factorialNumber.inNumber.size() > 0) || (carry != 0)) {
                Integer first = (inNumber.size() > 0) ? inNumber.remove(0) : 0;
                Integer second = (factorialNumber.inNumber.size() > 0) ? factorialNumber.inNumber.remove(0) : 0;
                Integer sum = first + second + carry;
                carry = sum > i ? 1 : 0;
                result.add(sum > i ? sum - (i + 1) : sum);
                i++;
            }
            this.inNumber = result;
            getInNumber();
            return this;
        }

    public FactorialNumber removeFromFactorialNumberAnotherNumber (FactorialNumber factorialNumber) {
        LinkedList<Integer> result = new LinkedList<>();
        Integer decreaseByOne = 0;
        Integer i = 1;
        while ((inNumber.size() > 0) || (factorialNumber.inNumber.size() > 0) || (decreaseByOne != 0)) {
            Integer first = (inNumber.size() > 0) ? inNumber.remove(0) : 0;
            Integer second = (factorialNumber.inNumber.size() > 0) ?
                    factorialNumber.inNumber.remove(0) : 0;
            Integer subtraction = first - second + decreaseByOne;
            decreaseByOne = subtraction < 0 ? -1 : 0;
            result.add(subtraction < 0 ? (i + 1) + subtraction : subtraction);
            i++;
        }
        this.inNumber = result;
        getInNumber();
        return this;
    }

    public FactorialNumber increaseByOne() {
        return this.addToFactorialNumberAnotherNumber(new FactorialNumber(new LinkedList<>(Arrays.asList(1))));
    }

    public FactorialNumber decreaseByOne() {
        return this.removeFromFactorialNumberAnotherNumber(new FactorialNumber(new LinkedList<>(Arrays.asList(1))));
    }
}
