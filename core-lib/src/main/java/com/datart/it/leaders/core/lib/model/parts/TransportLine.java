package com.datart.it.leaders.core.lib.model.parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.datart.it.leaders.core.lib.model.parts.Part.currentWorkflow;


public class TransportLine {
    private int line; //линия
    public List<Part> tsLine;

    public TransportLine(int line) {
        this.line = line;
    }

    void addPart(Part part){
        tsLine.add(part);
    }

    void AddParts(List<Part> parts){
        tsLine.add((Part) parts);
    }

    void Prepare(){

    }

}
