package com.datart.it.leaders.core.lib.model.plant;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class TransportLine {
    public List<TransportBox> boxes;

    public TransportLine() {
        boxes = new LinkedList<>();
    }

    public List<Part> unloadAll() {
        List<Part> parts = boxes.stream().map(box -> box.part).collect(Collectors.toList());
        boxes.clear();
        return parts;
    }

    public void loadPart(Part part, Integer time) {
        boxes.add(new TransportBox(part,time));

    }

    public void loadParts(List<Part> parts) {
        AtomicInteger finishTime=new AtomicInteger(0);
        parts.stream().forEach(part-> loadPart(part,finishTime.addAndGet(part.getLastOperationTime())));
    }

    public void Prepare() {
        //Удалить все детали завершенные
        boxes = boxes.stream().filter(part -> !part.part.isFinishd()).collect(Collectors.toList());
        //Отсортировать все детали по значению currentWorkFlow.get(0).time
        boxes.sort((box1, box2) -> {
            if (box1.finishTime > box2.finishTime)
                return 1;
            if (box1.finishTime < box2.finishTime)
                return -1;
            return 0;
        });
    }

    private class TransportBox{
        private Part part;
        private Integer finishTime;

        public TransportBox(Part part, Integer finishTime) {
            this.part = part;
            this.finishTime = finishTime;
        }

    }

}