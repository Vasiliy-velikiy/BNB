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

    void addPart(Part part){
        asmLine.add(part);
        workTime += part.currentWorkflow.get(0).getTime();
    }

    void addParts(List<Part>parts){
        asmLine.add((Part) parts);
    }

    List<Part> Process(int time){
        int t = 0;

        do {
            asmLine.get(1);

        }
    }
}
