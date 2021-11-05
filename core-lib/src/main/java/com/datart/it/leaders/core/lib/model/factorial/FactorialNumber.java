package com.datart.it.leaders.core.lib.model.factorial;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class FactorialNumber {
    /**
     * факториальное число,хранится в структуре данных LinkedList
     */
    final LinkedList<Integer> inNumber;

    /**
     * факториальное число, инициализируется в кострукторе,в нем так же находится проверка ,что число в фк системе счисления
     * int rankFactorial - инициализируется размером inNumber. используется для сравнения разрядности числа с элементом массива
     * int rslCouner - счетчик,для проверки, что все числа являются факториальными
     * в цикле сравниваем,что значение элемента не выходит за разрядность его числа,прибавляем 1,если условие верно
     * и сравниваем результат, еслы на ввыходе rslCounter равен size,все елементы соответствуют.
     * @param inNumber
     */
    public FactorialNumber (LinkedList<Integer> inNumber) {
        int rankFactorial = inNumber.size();
        int rslCounter = 0;
        for (Integer integer : inNumber) {
            if (integer <= rankFactorial--) {
                rslCounter = rslCounter + 1;
            }
        }
        if (rslCounter != inNumber.size()) {
            this.inNumber = null;
        } else {
            this.inNumber = inNumber;
        }
    }

    /**
     * сравниваем в цикле числа входящего числа с изначальным
     * @param factorialNumber
     * @return false если числа не соответствуют
     */
    public boolean equals(FactorialNumber factorialNumber) {
        boolean rsl = true;
        for (int i = 0; i < inNumber.size(); i++) {
            if (!factorialNumber.inNumber.get(i).equals(inNumber.get(i))) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    public LinkedList<Integer> addToFactorialNumber1 () {
        LinkedList<Integer> tempResult = new LinkedList<>(inNumber);
        int rankFactorial = 1;
        ListIterator<Integer> element = tempResult.listIterator(tempResult.size());
        int descendingNumberInList = element.previous();
        int indexOfDescendingNumber = inNumber.indexOf(descendingNumberInList);
        while (element.hasPrevious()) {
            if (descendingNumberInList + 1 <= rankFactorial) {
                tempResult.add(indexOfDescendingNumber, tempResult.remove(indexOfDescendingNumber) + 1);
                break;
            } else {
                int currentNumber = tempResult.remove(indexOfDescendingNumber);
                tempResult.add(indexOfDescendingNumber, (rankFactorial + 1) - (currentNumber + 1));
                rankFactorial++;
            }
        }
        return tempResult;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(4, 0, 2, 1);
        LinkedList<Integer> linkedList = new LinkedList<>(list);
        FactorialNumber fc = new FactorialNumber(linkedList);
        LinkedList<Integer> rs = fc.addToFactorialNumber1();
        System.out.println(rs);
    }
}
