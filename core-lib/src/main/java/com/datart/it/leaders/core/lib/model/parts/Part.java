package com.datart.it.leaders.core.lib.model.parts;

import java.util.ArrayList;

public class Part{  //конкретная деталь которая запускаеися на конвеер прямо сейчас
    private int id; //индентификатор детали
    private PartType type; //тип детали
    public ArrayList<Work> currentWorkflow;

    public Part(int id, PartType type){
        this.id=id;
        this.type=type;
    }

    public PartType getType() {
        return type;
    }
}