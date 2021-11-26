package com.datart.it.leaders.core.lib.model.parts;

import java.util.ArrayList;
import java.util.List;

public class AssemblingLine {

    int id;
    int workTime = 0;
    public List<Part> asmLine = new ArrayList<>();


    public AssemblingLine(int id) {
        this.id = id;
    }

    public void addPart(Part part){
        asmLine.add(part);
        workTime += part.currentWorkflow.get(0).getTime();
    }

    public void addParts(List<Part> parts){
        asmLine.addAll(parts);
    }

    public List<Part> Process(int time) {
        int t = 0;
        int i = 0;
        List<Part> finishedParts = null;
        while (t <= time) {
            Part curPart = asmLine.get(i);
            t += curPart.currentWorkflow.get(0).getTime();
            if (t > time) {
                curPart.currentWorkflow.get(0).setTime(t - time);
                finishedParts.add(curPart);
                break;
            }
            curPart.currentWorkflow.get(0).setTime(t);
            finishedParts.add(curPart);
            i++;
        }
        return finishedParts;
    }

}
