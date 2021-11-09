package com.datart.it.leaders.core.lib.model.parts;

import java.util.List;

public class Plant {
    /*
    Список линий производств
    TransportLines variables
    getHighMetric()
    getLowMetric()
     */

    List<AssemblingLine> lines;   //список станков или производственных линий
    TransportLine transportLine = new TransportLine();


    void Plant(int linesCount) {        //?? метод создания  производствен линий?

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
