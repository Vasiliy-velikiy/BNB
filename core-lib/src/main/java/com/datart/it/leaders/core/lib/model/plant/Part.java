package com.datart.it.leaders.core.lib.model.plant;

import java.util.LinkedList;
import java.util.List;

public class Part {
    private Integer id;
    private PartType partType;
    private  List<Work> currentWorkflow;

    public Part(Integer id, PartType partType) {
        this.id=id;
        this.partType=partType;
        this.currentWorkflow = new LinkedList<>(partType.getWorkflow());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PartType getPartType() {
        return partType;
    }

    public void setPartType(PartType partType) {
        this.partType = partType;
    }

    public List<Work> getCurrentWorkflow() {
        return currentWorkflow;
    }

    public void setCurrentWorkflow(List<Work> currentWorkflow) {
        this.currentWorkflow = currentWorkflow;
    }
}