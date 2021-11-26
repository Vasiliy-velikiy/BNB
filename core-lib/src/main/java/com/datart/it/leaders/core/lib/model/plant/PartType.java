package com.datart.it.leaders.core.lib.model.plant;
import java.util.List;

public class PartType{
    private Integer id; //индентификатор типа
    private List<Work> workflow; //порядок и время обработки детали.( через сколько и каких линий должна пройти деталь чтобы быть готовой)

    public PartType(Integer id, List<Work> workflow) {
        this.id = id;
        this.workflow = workflow;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Work> getWorkflow() {
        return workflow;
    }

    public void setWorkflow(List<Work> workflow) {
        this.workflow = workflow;
    }
}
