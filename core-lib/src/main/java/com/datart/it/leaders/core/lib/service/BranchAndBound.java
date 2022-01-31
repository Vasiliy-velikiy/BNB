package com.datart.it.leaders.core.lib.service;

import com.datart.it.leaders.core.lib.model.bound.BNBResult;
import com.datart.it.leaders.core.lib.model.branch.Branch;
import com.datart.it.leaders.core.lib.model.plant.Plant;

import java.util.Stack;
/**Класс для вычисления оптимальной перестановки методом ветвей и грнаиц*/
public class BranchAndBound {

    private Stack<BNBResult> stack;
    private Plant plant;
    private Long lBound;

    public BranchAndBound(Integer lineCount) {
        stack = new Stack<>();
        plant = new Plant(lineCount);
        lBound = Long.MAX_VALUE;
    }

    //Найти перестановку с минимальной метрикой
    public BNBResult process(Branch branch, Long metric) {
        lBound = metric;
        stack.clear();
        BNBResult result = null;

        //Запихать в стек первоначальную перестановку
        stack.push(new BNBResult(branch, plant.lowMetric(branch), plant.highMetric(branch)));
        //Пока в стеке есть перестановки для расчета
        while (!stack.isEmpty()) {
            //Получаем перестановку из стека
            BNBResult item = stack.pop();
            //Если метрика перестановки больше текущего рекорда-перестановку выбрасываем(нет смысла вычислять заведомо худшие)
            if (lBound < item.gethMetric()) {
                continue;
            }
            //форкаем ветку, если форкнуть не получилось, значит ветка обсчита до конца и ее выбрасываем
            Branch task = item.getBranch().fork();
            if (task == null) {
                continue;
            }
            //Если ветка обсчитана не до конца вернем ее в стек
            stack.push(item);

            //Вычислим hMetric -метрику до указателя base, и если даже она больше текущего рекорда, то считать дальше не стоит
            Long hMetric = plant.highMetric(task);
            if (lBound < hMetric) {
                continue;
            }
            //Вычислим полную метрику перестановки, и если она МЕНЬШЕ рекорда-обновим рекорд
            Long lMetric = plant.lowMetric(task);
            if (lBound > lMetric) {
                lBound = lMetric;
                result = new BNBResult(task, lMetric, hMetric);
            }
            //Запихнем перестановку в стек, в следующий раз начнем форкать ее
            stack.push(new BNBResult(task, lMetric, hMetric));
        }
        return result;
    }


}
