package com.datart.it.leaders.core.lib.model.plant;

import java.util.List;

public class TransportLine {
    private Integer line; //линия
    private List<Part> tsLine;

    public TransportLine(Integer line, List<Part> tsLine) {
        this.line = line;
        this.tsLine = tsLine;
    }

    public Integer getLine() {
        return line;
    }

    public void setLine(Integer line) {
        this.line = line;
    }

    public List<Part> getTsLine() {
        return tsLine;
    }

    public void setTsLine(List<Part> tsLine) {
        this.tsLine = tsLine;
    }
}
