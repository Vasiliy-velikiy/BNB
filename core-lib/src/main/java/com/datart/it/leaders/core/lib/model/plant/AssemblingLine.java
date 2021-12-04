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

    public void addPart(Part part) {
        line.add(part);
        workTime += part.getWorkTime();
    }

    public void addParts(List<Part> parts) {
        parts.stream().forEach(part -> addPart(part));
    }

    public List<Part> Process(Integer time) {
        Integer curTime=time;
        List<Part> finishedParts = new LinkedList<>();
        while (curTime > 0) {
            Part curPart = line.remove(0);
            curTime = curPart.process(curTime);
            if (curTime >= 0) {
                finishedParts.add(curPart);
            } else {
                line.add(0, curPart);
            }
        }
        this.workTime -= time;
        return finishedParts;
    }

    public Integer getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Integer workTime) {
        this.workTime = workTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Part> getLine() {
        return line;
    }

    public void setLine(List<Part> line) {
        this.line = line;
    }
}
