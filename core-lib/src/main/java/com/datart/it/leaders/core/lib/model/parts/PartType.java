package com.datart.it.leaders.core.lib.model.parts;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PartType{
    private int id; //индентификатор типа
    public LinkedList<Work> workflow; //порядок и время обработки детали.( через сколько и каких линий должна пройти деталь чтобы быть готовой)

    public PartType(int id ) {
        this.id = id;

    }
}
