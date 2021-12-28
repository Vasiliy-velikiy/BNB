package com.dataart.it.leaders.rest.api.model;


import com.datart.it.leaders.core.lib.model.bound.BNBResult;
import javafx.scene.transform.ShearBuilder;
import org.springframework.stereotype.Component;

import java.util.Map;
/**Класс содержит результаты вычислений от главного вычислителя*/
@Component
public class Context {
    private BNBResult bnbResult;
    private Integer count;
    private static Context instance;

    //для хранения ответов живой не живой от вычислителей
    private Map<String, Integer>mapAlive;

   private Context() {
    }

    public Context(BNBResult bnbResult) {
        this.bnbResult = bnbResult;
    }

    public Map<String, Integer> getMapAlive() {
        return mapAlive;
    }

    public void setMapAlive(Map<String, Integer> mapAlive) {
        this.mapAlive = mapAlive;
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
