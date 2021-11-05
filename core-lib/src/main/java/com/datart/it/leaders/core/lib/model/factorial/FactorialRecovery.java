package com.datart.it.leaders.core.lib.model.factorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class FactorialRecovery {
    final ArrayList<Integer> firstRearrangment;

    /**
     * Инициализация конструктора, ArrayList<Integer>, в котором находятся элементы начальной перестановки
     * @param firstRearrangment
     */
    public FactorialRecovery (ArrayList<Integer> firstRearrangment) {
        this.firstRearrangment = firstRearrangment;
    }

    /**
     * Метод принимает, объект FactorialNumber, в котором находится индекс в факториальной системе счисления.
     * tempRsl - времменый массив, в который мы расставляем элементы в нужном порядке из firstRearrangment.
     * ArrayList<Integer> position - массив в котором хранятся индексы, для расстановки элементов в результирующий массив
     * int counter - счетчик для заполнения индексов в position.
     * int counterOfFRNumberOut - счетчик для числе элементов из firstRearrangment
     * while - цикл для расстонвки индексов в position от чисел firstRearrangment.size() - 1 до 0.
     * for - цикл в котором мы поочередно берем индекс из FactorialNumber, удаляем ячейку под этим индексом из
     * positionControl, получая нужный индекс для заполнения в результирующий массив tempRsl.
     * последнее удаление из массива tempRsl, являеется последним элементом перестановки.
     * @param factorialNumber
     * @return ArrayList<Integer> rsl
     */
    public ArrayList<Integer> recoveryByFactorialNumber (FactorialNumber factorialNumber) {
        Integer[] tempRsl = new Integer[firstRearrangment.size()];
        LinkedList<Integer> positionControl = new LinkedList<>();
        int counter = firstRearrangment.size() - 1;
        int counterOfFRNumberOut = 0;
        while (counter != -1) {
            positionControl.add(counter);
            counter--;
        }
        for (Integer i : factorialNumber.inNumber) {
            int index = i;
            tempRsl[positionControl.remove(index)] = firstRearrangment.get(counterOfFRNumberOut++);
        }
        tempRsl[positionControl.get(0)] = firstRearrangment.get(firstRearrangment.size() - 1);
        return new ArrayList<>(Arrays.asList(tempRsl));
    }
}
