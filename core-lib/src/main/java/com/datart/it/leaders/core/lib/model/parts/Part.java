package com.datart.it.leaders.core.lib.model.parts;

import java.util.LinkedList;

public class Part{  //конкретная деталь которая запускаеися на конвеер прямо сейчас
    private int id; //индентификатор детали
    private PartType type; //тип детали
    public LinkedList<Work> currentWorkflow;

    public Part(int id, PartType type){
        this.id=id;
        this.type=type;
    }

    public Part(Integer id, PartType partType) {
        currentWorkflow = new PartType(id).workflow;
    }

    public PartType getType() {
        return type;
    }
}