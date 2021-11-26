package com.datart.it.leaders.core.lib.model.plant;

import java.util.LinkedList;
import java.util.List;

public class AssemblingLine {

    private Integer id;
    private Integer workTime = 0;
    private List<Part> line = new LinkedList<>();


    public AssemblingLine(Integer id) {
        this.id = id;
    }

    public void addPart(Part part){
        line.add(part);
        workTime += part.getCurrentWorkflow().get(0).getTime();
    }

    public void addParts(List<Part> parts){
        parts.stream().forEach(part->addPart(part));
    }

    public List<Part> Process(Integer time) {
        Integer t = 0;
        List<Part> finishedParts = new LinkedList<>();
        while (t <= time) {
                Part curPart = line.remove(0);
                t += curPart.getCurrentWorkflow().get(0).getTime();
                if (t <= time) {
                    finishedParts.add(curPart);
                } else {
                    curPart.getCurrentWorkflow().get(0).setTime(t - time);
                    line.add(0,curPart);
                }
        }
        return finishedParts;
    }
}
