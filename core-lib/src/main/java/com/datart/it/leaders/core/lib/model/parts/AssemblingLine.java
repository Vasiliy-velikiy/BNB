package com.datart.it.leaders.core.lib.model.parts;

import java.util.ArrayList;
import java.util.List;

import static com.datart.it.leaders.core.lib.model.parts.Part.currentWorkflow;

public class AssemblingLine {

    int id;
    int workTime;
    public ArrayList<Part> asmLine;
    int T; // минимальное время работы линии

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

        do {
            if(asmLine.contains(id)) {
                asmLine.get(id);
                t = t + asmLine.get(0).currentWorkflow.get(0).getTime();
                time = t;
            }
            if (t <= T){
                t = currentWorkflow.get(0).getTime();
                T -= t;
            }
        } while (t<= T);
        return asmLine;
    }
}
