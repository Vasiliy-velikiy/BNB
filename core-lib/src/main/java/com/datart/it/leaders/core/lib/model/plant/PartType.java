package com.datart.it.leaders.core.lib.model.plant;

import java.util.List;
import java.util.Optional;

public class PartType {
    private final Integer id; //индентификатор типа
    private final Work[] workflow; //порядок и время обработки детали.( через сколько и каких линий должна пройти деталь чтобы быть готовой)

    public PartType(Integer id, Work[] workflow) {
        this.id = id;
        this.workflow = workflow;
    }

    public Integer getId() {
        return id;
    }

    public Optional<Work> getWork(Integer pos) {
        Work retval = null;
        if (pos >= 0 && pos <= workflow.length-1) {
            retval = workflow[pos];
        }
        return Optional.ofNullable(retval);
    }
}