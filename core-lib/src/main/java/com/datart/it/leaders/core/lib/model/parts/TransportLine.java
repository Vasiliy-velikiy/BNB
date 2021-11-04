package com.datart.it.leaders.core.lib.model.parts;

import java.util.ArrayList;

public class TransportLine {
    private int line; //линия
    public ArrayList<Part> tsLine;

    public TransportLine(int line) {
        this.line = line;
    }

    public void putOnTsLine(/*Parts*/) {
        tsLine.add(/*Parts*/);
    }

    public void transport(){

        if(/*Part.partType = asmLine.workflow && Part.Time > workflow */){
            /*asmLine.add(Part)*/
        } else if (/*Part.partType = asmLine.workflow && Part.Time < workflow*/){
            /*Delete part*/
        }

    }
}
