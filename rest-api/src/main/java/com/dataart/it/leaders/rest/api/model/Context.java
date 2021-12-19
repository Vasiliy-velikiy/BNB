package com.dataart.it.leaders.rest.api.model;


import com.datart.it.leaders.core.lib.model.bound.BNBResult;
import org.springframework.stereotype.Component;

@Component
public class Context {
    private BNBResult bnbResult;
    private Integer count;
    private static Context instance;

   private Context() {
    }

    public Context(BNBResult bnbResult) {
        this.bnbResult = bnbResult;
    }

    public BNBResult getBnbResult() {
        return bnbResult;
    }

    public Integer getCount() {
        return count;
    }

    //синглтон
    public static Context getInstance(BNBResult bnbResult) {
        if(instance==null){
            instance= new Context(bnbResult);
        }
        return instance;
    }
    public void setBnbResult(BNBResult bnbResult) {
        this.bnbResult = bnbResult;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
