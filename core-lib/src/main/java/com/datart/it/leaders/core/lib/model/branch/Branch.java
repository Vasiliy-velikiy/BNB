package com.datart.it.leaders.core.lib.model.branch;
//Сущность "ветка" внутри это массив с одним или двумя указателями для удобства ветвления.

import java.util.LinkedList;
import java.util.List;
/**Класс описывает определенную последоваетльность элементов- элементы загружаются в оперделеном порядке на сборочную линию*/
public class Branch {

    private List<Object> sequence;
    private Integer base;
    private Integer forkPointer;


    public Branch(){
       this.sequence =new LinkedList<>();
    }

    public Branch(List<Object> sequence) {
        this.sequence = sequence;
        this.base = 0;
        this.forkPointer =0;
    }

    //конструктор копирования
    public Branch(Branch srcBranch){
        this.base = srcBranch.base;
        this.forkPointer = srcBranch.forkPointer;
        this.sequence =new LinkedList<>();
        this.sequence.addAll(srcBranch.sequence);
    }


    public List<Object> getSequence() {
        return sequence;
    }

    public Integer getBase() {
        return base;
    }

    public Integer getForkPointer() {
        return forkPointer;
    }

    public void setSequence(List<Object> sequence) {
        this.sequence.addAll(sequence);
    }

    public void setBase(Integer base) {
        this.base = base;
    }

    public void setForkPointer(Integer forkPointer) {
        this.forkPointer = forkPointer;
    }

    public Branch fork(){

        if ((base >= sequence.size()-1)||(forkPointer >= sequence.size()-1)){
            return null;
        }
        forkPointer++;
        Branch newBranch =new Branch(this);
        List<Object> newList = newBranch.getSequence();
        Object forkElement = newList.remove((int) forkPointer);    //remove(indicatorTwo);
        newList.add(base +1,forkElement);
        newBranch.setBase(base +1);
        newBranch.setForkPointer(base +2);
        return newBranch;
    }
}