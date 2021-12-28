package com.datart.it.leaders.core.lib.model.plant;

import java.util.Optional;

public class Part {             //каждая деталь на заводе имеет определнный тип , айди, время обработки и текущую позицию
    private final Integer id;
    private final PartType partType;
    private Integer workTime;
    private Integer curpos;

    public Part(Integer id, PartType partType) {
        this.id = id;
        this.partType = partType;
        curpos = 0;                     //ifPresent-Если значение присутствует, вызвать указанного потребителя со значением,* в противном случае ничего не делать.
        partType.getWork(curpos).ifPresent(work -> {   //у типа детали (например шар) я вынимаю текущую работу по позиции 0 если она существует,и получаю у этой работы время
            this.workTime = work.getTime();
        });

    }

    public Integer getId() {
        return id;
    }

    public PartType getPartType() {
        return partType;
    }

    //Обработать деталь за время time, на выходе оставшееся свободное время
    public Integer process(Integer time) {
        Integer retTime = time - workTime;
        if (retTime >= 0) {
            curpos++;
            partType.getWork(curpos).ifPresent(work -> {
                workTime = work.getTime();
            });
        } else {
            workTime -= time;
        }
        return (retTime);
    }

    //Обработка закончена если больше нет работ в списке
    public Boolean isFinishd() {
        return !partType.getWork(curpos).isPresent();
    }

    public Integer getWorkTime() {
        return workTime;
    }

    //Получить время предыдущего шага обработки для вычисления времени завершения обработки
    public Integer getLastOperationTime() {
        return partType.getWork(curpos - 1).map(work -> work.getTime()).orElse(0);
    }

    public Integer getLine() {
        return partType.getWork(curpos).map(work -> work.getLine()).orElse(0);
    }
}