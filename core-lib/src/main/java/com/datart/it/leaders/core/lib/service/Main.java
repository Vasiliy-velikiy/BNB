package com.datart.it.leaders.core.lib.service;



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
        //тестовый код чтобы показать перемещение указателей и перестановки
        //перестановка 312465

       /* Node test=new Node(312465);
        System.out.println(test.getLinkedListList());
        System.out.println(test.getPermutation());
     Node test2=  test.fork(test);
        System.out.println(test2.getLinkedListList());
        System.out.println(test2.getPermutation());

        Node test3=  test.fork(test2);*/
        //System.out.println(test3.getLinkedListList());






      /*  Node test=new Node(312465);
        System.out.println("indicatorOne-  "+test.getIndicatorOne()+"   indicatorTwo-"+test.getIndicatorTwo());
        System.out.println("oldnode--->"+test.getLinkedListList());
        System.out.println(test);
        System.out.println("-----------------------");

        Node newnode= fork(test);
        System.out.println("indicatorOne-  "+newnode.getIndicatorOne()+"   indicatorTwo-"+newnode.getIndicatorTwo());
        System.out.println("newnode--->"+ newnode.getLinkedListList());
        System.out.println(newnode);

        Node newnode1= fork(newnode);
        System.out.println("indicatorOne-  "+newnode1.getIndicatorOne()+"   indicatorTwo-"+newnode1.getIndicatorTwo());
        System.out.println("newnode1--->"+newnode1.getLinkedListList());
        System.out.println(newnode1);

        Node newnode2= fork(newnode1);
        System.out.println("indicatorOne-  "+newnode2.getIndicatorOne()+"   indicatorTwo-"+newnode2.getIndicatorTwo());
        System.out.println("newnode2--->"+newnode1.getLinkedListList());
        System.out.println(newnode2);

        Node newnode3= fork(newnode2);
        System.out.println("indicatorOne-  "+newnode3.getIndicatorOne()+"   indicatorTwo-"+newnode3.getIndicatorTwo());
        System.out.println("newnode4--->"+newnode3.getLinkedListList());
        System.out.println(newnode3);
        System.out.println("-------------");

        Node newnode4= fork(newnode3);
        System.out.println("indicatorOne-  "+newnode4.getIndicatorOne()+"   indicatorTwo-"+newnode4.getIndicatorTwo());
        System.out.println("newnode4--->"+newnode4.getLinkedListList());
        System.out.println(newnode4);

        Node newnode5= fork(newnode4);
        System.out.println("indicatorOne-  "+newnode5.getIndicatorOne()+"   indicatorTwo-"+newnode5.getIndicatorTwo());
        System.out.println("newnode5--->"+newnode5.getLinkedListList());
        System.out.println(newnode5);

        Node newnode6= fork(newnode5);
        System.out.println("indicatorOne-  "+newnode6.getIndicatorOne()+"   indicatorTwo-"+newnode6.getIndicatorTwo());
        System.out.println("newnode6--->"+newnode6.getLinkedListList());
        System.out.println(newnode6);

        Node newnode7= fork(newnode6);
        System.out.println("indicatorOne-  "+newnode7.getIndicatorOne()+"   indicatorTwo-"+newnode7.getIndicatorTwo());
        System.out.println("newnode7--->"+newnode7.getLinkedListList());
        System.out.println(newnode7);

        Node newnode8= fork(newnode7);
        System.out.println("indicatorOne-  "+newnode8.getIndicatorOne()+"   indicatorTwo-"+newnode8.getIndicatorTwo());
        System.out.println("newnode8--->"+newnode8.getLinkedListList());
        System.out.println(newnode8);

        Node newnode9= fork(newnode8);
        System.out.println("indicatorOne-  "+newnode9.getIndicatorOne()+"   indicatorTwo-"+newnode9.getIndicatorTwo());
        System.out.println("newnode9--->"+newnode9.getLinkedListList());
        System.out.println(newnode9);

        Node newnode10= fork(newnode9);
        System.out.println("indicatorOne-  "+newnode10.getIndicatorOne()+"   indicatorTwo-"+newnode10.getIndicatorTwo());
        System.out.println("newnode10--->"+newnode10.getLinkedListList());
        System.out.println(newnode10);*/
    }



       /* static Node fork(Node node){
            //Node newNode=new Node(i.permutation,i.indicatorOne,i.indicatorTwo,i.arrayList);
            Node newNode=new Node(node);
            if (newNode.getIndicatorTwo()==newNode.getLinkedListList().size()-1){
                newNode.incrementIndicatorOne(1);
                newNode.permutationIndicatorTwo();
            }

            if (newNode.getIndicatorOne()>=newNode.getLinkedListList().size()-2){
                return null;
            }

            int indicatorOne=newNode.getIndicatorOne();
            int indicatorTwo=newNode.incrementIndicatorTwo(1);

            int temp=newNode.getLinkedListList().get(indicatorTwo);
            newNode.getLinkedListList().remove((Object)temp);
            newNode.getLinkedListList().add(indicatorOne+1,temp);

            return newNode;
    }*/
}