package com.datart.it.leaders.core.lib.model.parts;

import java.util.ArrayList;
import java.util.List;

public class Part{  //конкретная деталь которая запускаеися на конвеер прямо сейчас
    private int id; //индентификатор детали
    private PartType type; //тип детали
    public List<Work> currentWorkflow;   //список станков, через которые должна пройти деталь

    public Part(int id, PartType type){
        this.id=id;
        this.type=type;
    }

    public Part(Integer id, PartType partType) {//инициализирую список станков текущей детали СПИСКОМ который должна пройти деаталь определенного типа чтобы быть готовой
        this.currentWorkflow = new PartType(id).workflow;
    }

    public PartType getType() {
        return type;
    }
}