package com.datart.it.leaders.core.lib.model.factorial;

import java.util.ArrayList;
import java.util.LinkedList;

public class FactorialRecovery {
    final ArrayList<Integer> firstRearrangment;

    public FactorialRecovery (ArrayList<Integer> firstRearrangment) {
        this.firstRearrangment = firstRearrangment;
    }

    public ArrayList<Integer> recoveryByFactorialNumber (FactorialNumber factorialNumber) {
        ArrayList<Integer> rslRecovery = new ArrayList<>();// результирующий массив,в нем елементы в нужном порядке на выходе
        ArrayList<Integer> positionControl = new ArrayList<>();//массив с индексами елементов которые мы ищем
        int counter = firstRearrangment.size() - 1;//счетчик елементов,для добавления в обратном порядке в positionControl
        int counterOfFRNumberOut = 0;//счетчик елементов,массива начальной перестановки
        while (counter != -1) {// в цикле добавляю индексы от размера массива начальной перестановки - 1 до 0
            positionControl.add(counter);
            counter--;
        }
        for (Integer i : factorialNumber.inNumber) {// берем значения из factorialNumber
            int index = i;// получаем первый индекс для удаления из positionControl
           rslRecovery.add(positionControl.remove(index), firstRearrangment.get(counterOfFRNumberOut++));
           // добавляю в результирующий массив, удаляя индекс из positionControl, получаю нужный индекс для добавления
            // в результирующий массив,добавляя елементы из начальной перестановки по порядку
        }
        rslRecovery.add(positionControl.get(0), firstRearrangment.get(firstRearrangment.size() - 1));//добавление последнего ел.
     return rslRecovery;
    }

    public static void main(String[] args) {
        ArrayList<Integer> in = new ArrayList<>();
        in.add(1);
        in.add(2);
        in.add(3);
        in.add(4);
        in.add(5);
        FactorialRecovery fc = new FactorialRecovery(in);
        LinkedList<Integer> list = new LinkedList<>();
        list.add(4);
        list.add(0);
        list.add(2);
        list.add(0);
        FactorialNumber fn = new FactorialNumber(list);
        ArrayList<Integer> out = fc.recoveryByFactorialNumber(fn);
        for (Integer i : out) {
            System.out.println(i);
        }

    }
}
