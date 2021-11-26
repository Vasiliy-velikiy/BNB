package com.datart.it.leaders.core.lib.model.plant;

public class Work {
    private Integer line; //линия
    private Integer time ;//время обработки

    public Work(Integer line, Integer time) {
        this.line = line;
        this.time = time;
    }

    public Integer getLine() {
        return line;
    }

    public void setLine(Integer line) {
        this.line = line;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}