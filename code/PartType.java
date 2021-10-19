package code;

import Tests.Work;

import java.util.List;

public class PartType{
    private int id; //индентификатор типа
    List<Work> workflow; //порядок и время обработки детали.

    public PartType(int id, List<Work> workflow ) {
        this.id = id;
        this.workflow=workflow;
    }
}
