package com.datart.it.leaders.core.lib.model.parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class TransportLine {
    private int line; //линия
    public static List<Part> tsLine;

    public TransportLine(int line) {
        this.line = line;
    }

    public void addPart(Part part){
        tsLine.add(part);
    }

    public void AddParts(List<Part> parts){
        tsLine.add((Part) parts);
    }

    public void Prepare(){

    }

}
