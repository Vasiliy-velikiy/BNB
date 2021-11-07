package com.datart.it.leaders.core.lib.model.parts;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class TransportLine {
    public List<Part> tsLine;

    public TransportLine() {
        tsLine = new LinkedList<>();
    }

    public List<Part> getTsLine() {
        return tsLine;
    }

    public void addPart(Part part) {
        tsLine.add(part);

    }

    public void AddParts(List<Part> parts) {
        tsLine.addAll(parts);
    }

    public void Prepare() {
        //Удалить все детали у котороых currentWorkFlow.size()=1;
        tsLine = tsLine.stream().filter(item -> item.currentWorkflow.size() > 1).collect(Collectors.toList());
        //Отсортировать все детали по значению currentWorkFlow.get(0).time
        tsLine.sort((part1, part2) -> {
            int time1 = part1.currentWorkflow.get(0).getTime();
            int time2 = part2.currentWorkflow.get(0).getTime();
            if (time1 > time2)
                return 1;
            if (time1 < time2)
                return -1;
            return 0;
        });
        //Удалить у всех деталий первый workflow currentWorkFlow.remove(0);
        tsLine = tsLine.stream().map(part -> {
            part.currentWorkflow.remove(0);
            return part;
        }).collect(Collectors.toList());
    }

}
