package code;
//Сущность "ветка" внутри это массив с одним или двумя указателями для удобства ветвления.

import java.util.ArrayList;

public class  Node{

    int perestanivka;

    ArrayList<Integer>arrayList;
    int mark1=0;
    int mark2=1;



   Node(int i){
       String s= String.valueOf(i);
       arrayList=new ArrayList<>();

       for (int j = 0; j <s.length() ; j++) {
           arrayList.add(Integer.parseInt(String.valueOf(s.charAt(j))));

       }
   }



}