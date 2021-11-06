package com.datart.it.leaders.core.lib.model.factorial;

import java.util.LinkedList;

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
        int rankFactorial = 1;
        int indexOfElemenet = inNumber.size() - 1;
        while (rankFactorial <= inNumber.size()) {
            if (inNumber.get(indexOfElemenet--) > rankFactorial++) {
                throw new IllegalArgumentException("Number isn't FactorialNumber");
            }
        }
        this.inNumber = inNumber;
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
                Integer first = (inNumber.size() > 0) ? inNumber.remove(inNumber.size() - 1) : 0;
                Integer second = (factorialNumber.inNumber.size() > 0) ?
                        factorialNumber.inNumber.remove(factorialNumber.inNumber.size() - 1) : 0;
                Integer sum = first + second + carry;
                carry = sum > i ? 1 : 0;
                result.addFirst(sum > i ? sum - (i + 1) : sum);
                i++;
            }
            this.inNumber = result;
            return this;
        }

    public FactorialNumber removeFromFactorialNumberAnotherNumber (FactorialNumber factorialNumber) {
        LinkedList<Integer> result = new LinkedList<>();
        Integer carry = 0;
        Integer i = 1;
        while ((inNumber.size() > 0) || (factorialNumber.inNumber.size() > 0) || (carry != 0)) {
            Integer first = (inNumber.size() > 0) ? inNumber.remove(inNumber.size() - 1) : 0;
            Integer second = (factorialNumber.inNumber.size() > 0) ?
                    factorialNumber.inNumber.remove(factorialNumber.inNumber.size() - 1) : 0;
            Integer subtraction = first - second - carry;
            carry = subtraction < i && subtraction != 0 ? 1 : 0;
            result.addFirst(subtraction < i & subtraction != 0 ? subtraction + (i + 1) : subtraction);
            i++;
        }
        this.inNumber = result;
        return this;
    }

    public FactorialNumber increase() {
            LinkedList<Integer> result = new LinkedList<>(this.inNumber);
            result.addLast(1);
        return new FactorialNumber(result);
    }



        public static void main (String[]args){
            LinkedList<Integer> linkedList = new LinkedList<>();
            linkedList.add(4);
            linkedList.add(3);
            linkedList.add(2);
            linkedList.add(1);
            LinkedList<Integer> linkedList1 = new LinkedList<>();
            linkedList1.add(3);
            linkedList1.add(2);
            linkedList1.add(1);
            FactorialNumber fc = new FactorialNumber(linkedList);
            FactorialNumber fc1 = new FactorialNumber(linkedList1);
        FactorialNumber fc2 = fc.addToFactorialNumberAnotherNumber(fc1);
            System.out.println(fc2.inNumber);
        }
}
