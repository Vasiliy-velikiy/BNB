package com.dataart.it.leaders.rest.api.service.impl;

import com.dataart.it.leaders.rest.api.model.Context;
import com.datart.it.leaders.core.lib.model.bound.BNBResult;
import com.datart.it.leaders.core.lib.model.plant.Plant;
import org.springframework.batch.item.ItemProcessor;

    /**
     *В Классе-процессоре вычисляется low, high metric для
     * первоначальной перестановки которая пришла с контроллера Permutation Controller
     */
public class ProccesorForComputed implements ItemProcessor<BNBResult, BNBResult> {
    private Context context;

    public ProccesorForComputed(Context context) {
        this.context = context;
    }

    @Override
    public BNBResult process(BNBResult bnbResult) throws Exception {
        Plant plant=new Plant(context.getCount());

        bnbResult.sethMetric(plant.highMetric(bnbResult.getBranch()));
        bnbResult.setlMetric(plant.lowMetric((bnbResult.getBranch())));
        context.setBnbResult(bnbResult);
        return bnbResult;
    }
}
