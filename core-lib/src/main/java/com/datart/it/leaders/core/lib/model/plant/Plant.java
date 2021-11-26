package com.datart.it.leaders.core.lib.model.plant;

import java.util.LinkedList;
import java.util.List;

public class Plant {

    List<AssemblingLine> lines;   //список станков или производственных линий
    TransportLine transportLine;

    public Plant(Integer cnt) {
        lines=new LinkedList<>();
        transportLine = new TransportLine();
        for(Integer i=0;i<cnt;i++){
            lines.add(new AssemblingLine(i));
        }
    }

    long highMetric() {
        return 0;
    }

    long lowMetric() {
        return 0;
    }

    void Transport() {

    }
}
