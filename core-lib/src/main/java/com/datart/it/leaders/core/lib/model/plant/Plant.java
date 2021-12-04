package com.datart.it.leaders.core.lib.model.plant;

import com.datart.it.leaders.core.lib.model.branch.Branch;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Plant {

    private List<AssemblingLine> lines;   //список станков или производственных линий
    private TransportLine transportLine;

    public Plant(Integer cnt) {
        lines = new LinkedList<>();
        transportLine = new TransportLine();
        for (Integer i = 0; i < cnt; i++) {
            lines.add(new AssemblingLine(i));
        }
    }

    public Long highMetric(Branch branch) {
        clearLines();
        Integer base = branch.getBase();
        List<Part> subList = branch
                .getSequence()
                .subList(0, branch.getBase()+1)
                .stream()
                .map(obj -> (Part) obj)
                .collect(Collectors.toList());

        transportLine.loadParts(subList);
        transport();
        return process();
    }

    public Long lowMetric(Branch branch) {
        clearLines();
        List<Part> subList = branch
                .getSequence()
                .stream()
                .map(obj -> (Part) obj)
                .collect(Collectors.toList());
        transportLine.loadParts(subList);
        transport();
        return process();
    }

    private void transport() {
        transportLine.unloadAll().stream().forEach(part -> {
            lines.get(part .getLine()).addPart(part);
        });
    }

    private void clearLines() {
        lines.stream().forEach(line -> line.getLine().clear());
    }

    //Запустить фабрику на изготовление деталей
    private Long process() {
        Long metric = 0L;
        //получит минимальное время работы линии(пустые линии не считаем)
        Integer t = lines.stream().map(line -> line.getWorkTime()).filter(i -> i > 0).min(Integer::compare).get();
        //Если все линии пустые-значит закончили обработку всех деталей
        while (t > 0) {
            metric += t;
            //поработать время t и выгрузить делати на транспортер
            for (AssemblingLine line : lines) {
                if (line.getWorkTime()>0) {
                    transportLine.loadParts(line.Process(t));
                }
            }
            //Загрузить детали с транспортера на линии
            transportLine.Prepare();
            transport();
            //получит минимальное время работы линии(пустые линии не считаем)
            t = lines.stream().map(line -> line.getWorkTime()).filter(i -> i > 0).min(Integer::compare).orElse(0);
        }
        return metric;
    }

}
