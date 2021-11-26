package com.datart.it.leaders.core.lib.model.plant;

public class Part{  //конкретная деталь которая запускаеися на конвеер прямо сейчас
    private Integer id; //индентификатор детали
    private PartType type; //тип детали

    public Part(Integer id, PartType type){
        this.id=id;
        this.type=type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PartType getType() {
        return type;
    }

    public void setType(PartType type) {
        this.type = type;
    }
}