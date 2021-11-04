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

    public void putOnLine(/*Parts*/){
        asmLine.add();
        System.out.println("Details on work line");

        /* workTime = Parts.Time*/
    }
}
