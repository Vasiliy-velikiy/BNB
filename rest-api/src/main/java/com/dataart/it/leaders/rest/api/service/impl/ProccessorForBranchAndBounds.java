package com.dataart.it.leaders.rest.api.service.impl;

import com.dataart.it.leaders.rest.api.model.Context;
import com.datart.it.leaders.core.lib.model.bound.BNBResult;
import com.datart.it.leaders.core.lib.service.BranchAndBound;
import org.springframework.batch.item.ItemProcessor;
/**
 *В Классе-процессоре Запускается Branch and bounds расчет начиная с первоначальной перестановки
 */
public class ProccessorForBranchAndBounds implements ItemProcessor<Context,Context> {

    private Context context;
    private BranchAndBound branchAndBound;


    public ProccessorForBranchAndBounds() {
    }


    public ProccessorForBranchAndBounds(Context context, BranchAndBound branchAndBound) {
        this.context = context;
        this.branchAndBound = branchAndBound;
    }

        @Override
        public Context process (Context o) throws Exception {
            //т.к контекст -класс для результатов моих вычислений, оттуда я вынимаю перестановку, обсчитываю методом process (ветви и границы) и возвращаю результат в контекст
            context.setBnbResult(branchAndBound.process(o.getBnbResult().getBranch(), o.getBnbResult().gethMetric()));
            return context;
        }
    }

