package com.datart.it.leaders.core.lib.model.branch;
//Сущность "ветка" внутри это массив с одним или двумя указателями для удобства ветвления.

import java.util.LinkedList;
import java.util.List;

public class Branch {

    private List<Integer> sequence;
    private Integer base;
    private Integer forkPointer;



    // Конструкторы пишут вначале, чтобы не бегать по коду и не искать как сделать объект
    public Branch(){
       this.sequence =new LinkedList<>();
    }

    //конструктор копирования
    public Branch(Branch srcBranch){
        this.base = srcBranch.base;
        this.forkPointer = srcBranch.forkPointer;
        this.sequence =new LinkedList<>();
        this.sequence.addAll(srcBranch.sequence);
    }


    public List<Integer> getSequence() {
        return sequence;
    }

    public int getBase() {
        return base;
    }

    public int getForkPointer() {
        return forkPointer;
    }

    public void setSequence(List<Integer> sequence) {
        this.sequence.addAll(sequence);

    }

    public void setBase(Integer base) {
        this.base = base;
    }

    public void setForkPointer(Integer forkPointer) {
        this.forkPointer = forkPointer;
    }


    public Branch fork(){

        if ((base >= sequence.size())||(forkPointer >= sequence.size())){
            return null;
        }
        forkPointer++;
        Branch newBranch =new Branch(this);
        List<Integer> newList = newBranch.getSequence();
        Integer forkElement = newList.remove((int) forkPointer);    //remove(indicatorTwo);
        newList.add(base +1,forkElement);
        newBranch.setBase(base +1);
        newBranch.setForkPointer(base +2);
        return newBranch;
    }
}