package com.datart.it.leaders.core.lib.service;

import com.datart.it.leaders.core.lib.model.bound.BNBResult;
import com.datart.it.leaders.core.lib.model.branch.Branch;
import com.datart.it.leaders.core.lib.model.plant.Plant;

import java.util.Stack;

public class BranchAndBound {

    private Stack<BNBResult> stack;
    private Plant plant;
    private Long lBound;

    public BranchAndBound(Integer lineCount) {
        stack=new Stack<>();
        plant=new Plant(lineCount);
        lBound=Long.MAX_VALUE;
    }

    public BNBResult process(Branch branch, Long metric){
        lBound=metric;
        stack.clear();
        BNBResult result=null;
        stack.push(new BNBResult(branch, plant.lowMetric(branch), plant.highMetric(branch)));
        while (!stack.isEmpty()){
            BNBResult item = stack.pop();
            if(lBound<item.gethMetric()){
                continue;
            }
            Branch task = item.getBranch().fork();
            if(task==null){
                continue;
            }
            stack.push(item);
            Long hMetric = plant.highMetric(task);
            if (lBound< hMetric){
                continue;
            }
            Long lMetric = plant.lowMetric(task);
            if(lBound>lMetric){
                lBound=lMetric;
                result=new BNBResult(task,lMetric,hMetric);
            }
            stack.push(new BNBResult(task,lMetric,hMetric));
        }
        return result;
    }



}
