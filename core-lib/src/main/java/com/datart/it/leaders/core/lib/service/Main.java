package com.datart.it.leaders.core.lib.service;



import com.datart.it.leaders.core.lib.model.node.FactorialNumberSystem;
import com.datart.it.leaders.core.lib.model.node.Node;
import com.datart.it.leaders.core.lib.model.parts.Part;
import com.datart.it.leaders.core.lib.model.parts.PartType;
import com.datart.it.leaders.core.lib.model.parts.Work;

import java.math.BigInteger;
import java.util.ArrayList;
 /*коментарий от руководителя :
    Я пытаюсь тебе намекнуть что тебе нужен не массив а сущность "ветка". Передавая ее в функцию форк я получу подветку этой ветки.
    Внутреннее устройство ветки на твое усмотрение.
     */

//как хранить и получать "ветки"?  И как отмечать верхнюю и нижнюю метрики например?


/*На вход  податся ветка(возможно это первоначальная перестановка- уровень 0) и  на выходе получаю подветку уровня тогоже уровня
 или на уровень ниже, если на текущем уровне подветки кончились. Сущность "ветка" внутри это список с одним или двумя
  указателями для удобства ветвления. */
public class Main  {
    public static void main(String[] args) {
//тест
        FactorialNumberSystem factorialNumberSystem=new FactorialNumberSystem();
        char[]proverka=  factorialNumberSystem.recoveryPermutations("4020");

        System.out.println("number permutation: 4020");
        for(char t:mass){
            System.out.print(t+", ");
        }
        System.out.println();
        System.out.println("----------------");

        for(char t:proverka){
            System.out.print(t+", ");
        }


    }







    static char[]mass= {'a','b','c','d','e'};


}