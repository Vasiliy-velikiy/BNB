package com.datart.it.leaders.core.lib.model.node;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.rules.ExpectedException;
import org.mockito.internal.matchers.Null;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


class NodeTest {

    //пример теста
    @Test
    void forkOK() {
        Node node=new Node();
        List arr = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0})
                .boxed()
                .collect(Collectors.toList());
        node.setLinkedListList(arr);
        node.setIndicatorOne(0);
        node.setIndicatorTwo(2);
        Node newNode=node.fork();
        assertEquals(newNode.getIndicatorOne(),1);
        assertEquals(newNode.getIndicatorTwo(),2);
        arr = Arrays.stream(new int[]{1, 3, 2, 4, 5, 6, 7, 8, 9, 0})
                .boxed()
                .collect(Collectors.toList());
        assertEquals(newNode.getLinkedListList(),arr);
    }



    //я так и не понял что ты тут тестируешь? Нода из одного элемента проверяем что элемент не изменился после fork???
    //так он и не мог изменится!
    @Test
    void fork1() {
        Node node=new Node(123456);
        LinkedList actual=node.getLinkedListList();
        System.out.println(actual.toString());
        Node newNode1=node.fork(node);

        LinkedList expected=newNode1.getLinkedListList();
        System.out.println(expected.toString());

        assertEquals(expected,actual);
    }
    @Rule


    //Вот это я вообще не понял. Зачем столько форков?

    @Test   (expected=RuntimeException.class)
    void fork2() {
        Node node=new Node(123456);
        LinkedList actual=node.getLinkedListList();
 //  try {
    Node newNode1 = node.fork(node);
    Node newNode2 = node.fork(newNode1);
    Node newNode3 = node.fork(newNode2);
    Node newNode4 = node.fork(newNode3);
    Node newNode5 = node.fork(newNode4);
    Node newNode6 = node.fork(newNode5);
    Node newNode7 = node.fork(newNode6);
    Node newNode8 = node.fork(newNode7);
    Node newNode9 = node.fork(newNode8);
    Node newNode10 = node.fork(newNode9);
    Node newNode11 = node.fork(newNode10);
    Node newNode12 = node.fork(newNode11);
    Node newNode13 = node.fork(newNode12);
    Node newNode14 = node.fork(newNode13);
    Node newNode15 = node.fork(newNode14);
    Node newNode16 = node.fork(newNode15);
    Node newNode17 = node.fork(newNode16);
    Node newNode18 = node.fork(newNode17);

    LinkedList expected = newNode18.getLinkedListList();
    System.out.println(expected.toString());

    assertEquals(expected,actual);
    // }
    //catch (Exception thrown){
   //Assert.assertNotEquals("", thrown.getMessage());
       //  }
      }

    }