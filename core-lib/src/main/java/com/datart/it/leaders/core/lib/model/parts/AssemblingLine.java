package com.datart.it.leaders.core.lib.model.parts;

import java.util.ArrayList;
import java.util.List;

public class AssemblingLine {

    Integer id;
    Integer workTime = 0;   //общее время работы
    public List<Part> asmLine = new ArrayList<>();   //список деталей которые будет обрабатывать сборочная линия


    public AssemblingLine(int id) {
        this.id = id;
    }

    public void addPart(Part part){  //добавить деталь на линию сборки
        asmLine.add(part);     //почему увелич только по 1 позиции?
        workTime += part.currentWorkflow.get(0).getTime();  //общее время обработки  увеличить НА время текущей работы  у конкретной детали
    }


    public void addParts(List<Part> parts){  //добавить все детали в список сборочной линии
        asmLine.addAll(parts);
    }

    public List<Part> Process(int time) {  //время обработки процесса
        int t = 0;                      //нулевая метрика
        int i = 0;                      //счетчик
        List<Part> finishedParts = new ArrayList<>();  //список завершенных деталей
        while (t <= time) {         //пока нулевая метрика меньше заданного времени выполняется цикл
            Part curPart = asmLine.get(i);      //текущая деталь берется из начала списка
            t += curPart.currentWorkflow.get(0).getTime(); //увеличивается метрика на время обработки на 1 станке (у детали может быть несколько станков, перед тем как она будет готова)
            if (t > time) {                     //если метрика вышла за границу времени процесса
                curPart.currentWorkflow.get(0).setTime(t - time); // в текущей детали на времени у 1станка устанавливается разность между метрикой и временем процесса
                finishedParts.add(curPart);
                break;
            }
            curPart.currentWorkflow.get(0).setTime(t);
            finishedParts.add(curPart);
            i++;
        }
        return finishedParts;
    }

}
