package com.datart.it.leaders.core.lib.model.parts;

import java.util.List;

public class Plant {
    /*
    Список линий производств
    TransportLines variables
    getHighMetric()
    getLowMetric()
     */

    List<AssemblingLine> lines;
    TransportLine transportLine = new TransportLine(1);


    void Plant(int LinesCount){

    }

    long highMetric(){
        return 0;
    }

    long lowMetric(){
        return 0;
    }

    void Transport(){

    }
}
