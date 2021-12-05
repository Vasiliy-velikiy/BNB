package com.datart.it.leaders.core.lib.model.bound;

import com.datart.it.leaders.core.lib.model.branch.Branch;

import java.util.List;

public class BNBResult {
    private Branch branch;
    private Long lMetric;
    private Long hMetric;


    public BNBResult() {
    }

    public BNBResult(Branch branch, Long lMetric, Long hMetric) {
        this.branch = branch;
        this.lMetric = lMetric;
        this.hMetric = hMetric;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Long getlMetric() {
        return lMetric;
    }

    public void setlMetric(Long lMetric) {
        this.lMetric = lMetric;
    }

    public Long gethMetric() {
        return hMetric;
    }

    public void sethMetric(Long hMetric) {
        this.hMetric = hMetric;
    }
}
