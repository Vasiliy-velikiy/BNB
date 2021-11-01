package com.datart.it.leaders.core.lib.model.node;
//Сущность "ветка" внутри это массив с одним или двумя указателями для удобства ветвления.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class  Node{

    private int permutation;
    private LinkedList<Integer>linkedListList;
    private int indicatorOne;
    private int indicatorTwo;
// Конструкторы пишут вначале, чтобы не бегать по коду и не искать как сделать объект

    public Node(){
    }

    //Какой смысл в ветке с одним элементом ?
    public Node(int i){
        this.indicatorOne=0;
        this.indicatorTwo=1;
        this.permutation=i;
        String s= String.valueOf(i);
        linkedListList=new LinkedList<Integer>();

        for (int j = 0; j <s.length() ; j++) {
            linkedListList.add(Integer.parseInt(String.valueOf(s.charAt(j))));
        }
    }

    //конструктор копирования
    public Node(Node srcNode){
        this.indicatorOne=srcNode.indicatorOne;
        this.indicatorTwo=srcNode.indicatorTwo;
        this.permutation=srcNode.permutation;
        this.linkedListList.addAll(srcNode.linkedListList);
    }


    public int incrementIndicatorOne(int one){
        indicatorOne=indicatorOne+one;
        return indicatorOne;
    }
    public int incrementIndicatorTwo(int one){
       indicatorTwo= indicatorTwo+one;
       return  indicatorTwo;
    }

    public int permutationIndicatorTwo(){
      indicatorTwo=indicatorOne+1;
        return indicatorTwo;
    }

    public int getPermutation() {
        return permutation;
    }

    public LinkedList<Integer> getLinkedListList() {
        return linkedListList;
    }

    public int getIndicatorOne() {
        return indicatorOne;
    }

    public int getIndicatorTwo() {
        return indicatorTwo;
    }

    public void setPermutation(int permutation) {
        this.permutation = permutation;
    }

    public void setLinkedListList(List<Integer> linkedListList) {
        this.linkedListList.addAll(linkedListList);
    }

    public void setIndicatorOne(int indicatorOne) {
        this.indicatorOne = indicatorOne;
    }

    public void setIndicatorTwo(int indicatorTwo) {
        this.indicatorTwo = indicatorTwo;
    }

    //??? не понял. Это класс ноды. зачем тебе параметр еще одна нода?
    public Node fork(Node node){

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
    }

    //Вот все что нужно было сделать.
    public Node fork(){
        indicatorTwo++;
        if ((indicatorOne>=linkedListList.size())||(indicatorTwo>=linkedListList.size())){
            return null;
        }
        Node newNode=new Node(this);
        List newList = newNode.getLinkedListList();
        Object forkElement = newList.remove(indicatorTwo);
        newList.add(indicatorOne+1,forkElement);
        newNode.setIndicatorOne(indicatorOne+1);
        newNode.setIndicatorTwo(indicatorOne+2);
        return newNode;
    }

}