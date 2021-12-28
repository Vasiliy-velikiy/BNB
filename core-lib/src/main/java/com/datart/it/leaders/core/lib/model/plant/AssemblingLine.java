package com.datart.it.leaders.core.lib.model.plant;

import java.util.LinkedList;
import java.util.List;
/**Класс -сборочная линия или станок */
public class AssemblingLine {

    private Integer id;
    private Integer workTime = 0;  //время обработки деталей которые находятся в очереди
    private List<Part> line = new LinkedList<>();//линия у которой в очереди Детали


    public AssemblingLine(Integer id) {
        this.id = id;
    }

    public void addPart(Part part) {
        line.add(part);   //добавляю в очередь конкретной производственной линии детали
        workTime += part.getWorkTime();  //каждая деталь имеет собственное время обработки, а общее время обработки на сборочной линии увеличивается на величину у конкретной детали
    }

    public void addParts(List<Part> parts) {
        parts.addAll(parts);
    }

    //Обработать все детали которые успеем за время  time
    public List<Part> Process(Integer time) {
        Integer curTime=time;   //текущее время равно времени которое отводим на выполнение процесса
        List<Part> finishedParts = new LinkedList<>(); //список завершенных деталей
        //Пока есть время работаем
        while (curTime > 0) { //если текущее время больше нуля, тоесть имеется вообще какое то время
            Part curPart = line.remove(0); //удаляем из списка линии деталь
            curTime = curPart.process(curTime); //текущее время становиться временем обработки конкретной детали
            //если после обработки осталось свободное время значит деталь готова - отправить ее на транспортер
            if (curTime >= 0) {
                finishedParts.add(curPart);
            //иначе деталь еще не доделана и надо вернуть на линию обработки
            } else {
                line.add(0, curPart);
            }
        }
        this.workTime -= time;
        return finishedParts;
    }

    public Integer getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Integer workTime) {
        this.workTime = workTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Part> getLine() {
        return line;
    }

    public void setLine(List<Part> line) {
        this.line = line;
    }
}
