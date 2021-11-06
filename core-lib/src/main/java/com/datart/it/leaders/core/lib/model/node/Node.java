package com.datart.it.leaders.core.lib.model.node;
//Сущность "ветка" внутри это массив с одним или двумя указателями для удобства ветвления.

import java.util.ArrayList;

public class  Node{

    public int perestanivka;
    public ArrayList<Integer>arrayList;
    public int indicatorOne;
    public int indicatorTwo;

      public Node(int i){
       this.indicatorOne=0;
       this.indicatorTwo=1;
       this.perestanivka=i;
       String s= String.valueOf(i);
       arrayList=new ArrayList<Integer>();

       for (int j = 0; j <s.length() ; j++) {
           arrayList.add(Integer.parseInt(String.valueOf(s.charAt(j))));

       }
   }

    public Node(int i,int indicatorOne,int indicatorTwo,ArrayList<Integer>arrayList){
        this.indicatorOne=indicatorOne;
        this.indicatorTwo=indicatorTwo;
        this.perestanivka=i;
        this.arrayList=arrayList;

    }


}