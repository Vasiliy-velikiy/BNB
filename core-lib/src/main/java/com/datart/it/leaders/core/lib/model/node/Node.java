package com.datart.it.leaders.core.lib.model.node;
//Сущность "ветка" внутри это массив с одним или двумя указателями для удобства ветвления.

import java.util.LinkedList;
import java.util.List;

public class  Node{

    // Конструкторы пишут вначале, чтобы не бегать по коду и не искать как сделать объект
    public Node(){
    }

    private LinkedList<Integer> linkedList;
    private Integer indicatorOne;
    private Integer indicatorTwo;


    //конструктор копирования
    public Node(Node srcNode){
        this.indicatorOne=srcNode.indicatorOne;
        this.indicatorTwo=srcNode.indicatorTwo;
        this.linkedList.addAll(srcNode.linkedList);
    }


    public LinkedList<Integer> getLinkedList() {
        return linkedList;
    }

    public int getIndicatorOne() {
        return indicatorOne;
    }

    public int getIndicatorTwo() {
        return indicatorTwo;
    }

    public void setLinkedList(List<Integer> linkedList) {
        this.linkedList.addAll(linkedList);
    }

    public void setIndicatorOne(int indicatorOne) {
        this.indicatorOne = indicatorOne;
    }

    public void setIndicatorTwo(int indicatorTwo) {
        this.indicatorTwo = indicatorTwo;
    }


    public Node fork(){

        if ((indicatorOne>= linkedList.size())||(indicatorTwo>= linkedList.size())){
            return null;
        }
        indicatorTwo++;
        Node newNode=new Node(this);
        List newList = newNode.getLinkedList();
        Object forkElement = newList.remove(indicatorTwo);
        newList.add(indicatorOne+1,forkElement);
        newNode.setIndicatorOne(indicatorOne+1);
        newNode.setIndicatorTwo(indicatorOne+2);
        return newNode;
    }
}