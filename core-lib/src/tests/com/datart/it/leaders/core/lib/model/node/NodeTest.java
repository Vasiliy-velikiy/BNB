package com.datart.it.leaders.core.lib.model.node;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class NodeTest {


@Test
   public void forkOK() {
        Node node=new Node();
        List arr = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0})
                .boxed()
                .collect(Collectors.toList());
        node.setLinkedList(arr);
        node.setIndicatorOne(0);
        node.setIndicatorTwo(2);
        Node newNode=node.fork();
        assertEquals(newNode.getIndicatorOne(),1);
        assertEquals(newNode.getIndicatorTwo(),2);
        arr = Arrays.stream(new int[]{1, 3, 2, 4, 5, 6, 7, 8, 9, 0})
                .boxed()
                .collect(Collectors.toList());
        assertEquals(newNode.getLinkedList(),arr);
    }

    @Test (expected =NullPointerException.class)
  public   void forkExcept() {
        Node node=new Node();
        List arr = Arrays.stream(new int[]{1, 3, 2, 4, 5, 6, 7, 8, 9, 0})
                .boxed()
                .collect(Collectors.toList());
        node.setLinkedList(arr);
        node.setIndicatorOne(10);
        node.setIndicatorTwo(10);
        Node newNode=node.fork();
        assertEquals(newNode.getIndicatorOne(),10);
        assertEquals(newNode.getIndicatorTwo(),10);
        arr = Arrays.stream(new int[]{1, 3, 2, 4, 5, 6, 7, 8, 9, 0})
                .boxed()
                .collect(Collectors.toList());
        assertEquals(newNode.getLinkedList(),arr);
    }
}


/*import org.junit.Assert;
        import org.junit.Before;
        import org.junit.Rule;
        import org.junit.Test;
        import static org.junit.Assert.assertEquals;
        import org.junit.rules.ExpectedException;
        import org.mockito.internal.matchers.Null;


        import java.util.Arrays;
        import java.util.LinkedList;
        import java.util.List;
        import java.util.stream.Collectors;*/


