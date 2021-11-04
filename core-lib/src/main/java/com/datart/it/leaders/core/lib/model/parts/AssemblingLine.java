package com.datart.it.leaders.core.lib.model.parts;

import java.util.ArrayList;
import java.util.List;

public class AssemblingLine {

    int id;
    int workTime;
    public ArrayList<Part> asmLine;

    public AssemblingLine(int id) {
        this.id = id;
    }

    public int putOnLine(/*Parts*/){
        asmLine.add(/*Parts*/);
        System.out.println("Details on work line");
    }

    public int counter(){


    }
}
