package com.datart.it.leaders.core.lib.model.parts;

import java.util.ArrayList;
import java.util.List;

import static com.datart.it.leaders.core.lib.model.parts.Part.currentWorkflow;

public class AssemblingLine {

    int id;
    int workTime;
    public ArrayList<Part> asmLine;

    public AssemblingLine(int id) {
        this.id = id;
    }

    void addPart(Part part){
        asmLine.add(part);
        workTime += currentWorkflow.get(0).getTime();
    }

    void addParts(List<Part>parts){

        asmLine.add((Part) parts);
    }

    List<Part> Process(int time){
        int t = 0;
        for (int i = 0; i < asmLine.size(); i++) {
            asmLine.get(i);
            t = t + currentWorkflow.get(i).getTime();

            if(t <= time) {
                time -= currentWorkflow.get(i).getTime();
                t = currentWorkflow.get(i).getTime();
            } else break;
        }
        return asmLine;
    }

}
