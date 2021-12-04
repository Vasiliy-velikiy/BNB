package com.datart.it.leaders.core.lib.service;

import com.datart.it.leaders.core.lib.model.bound.BNBResult;
import com.datart.it.leaders.core.lib.model.branch.Branch;
import com.datart.it.leaders.core.lib.model.plant.Part;
import com.datart.it.leaders.core.lib.model.plant.PartType;
import com.datart.it.leaders.core.lib.model.plant.Work;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class BranchAndBoundTest {

    BranchAndBound bnb=new BranchAndBound(3);

    @Test
    public void process() {
        Work[] list = new Work[]{new Work(0,1),new Work(2,3)};
        PartType partType1 = new PartType(0, list);

        list = new Work[]{new Work(1,2),new Work(0,2),new Work(2,1)};
        PartType partType2 = new PartType(1, list);

        List<Object>parts=new LinkedList<>();
        parts.add(new Part(0,partType1));
        parts.add(new Part(2,partType1));
        parts.add(new Part(3,partType2));
        parts.add(new Part(4,partType2));
        parts.add(new Part(5,partType1));
        parts.add(new Part(6,partType2));
        parts.add(new Part(7,partType1));

        Branch branch = new Branch();
        branch.setSequence(parts);
        branch.setBase(0);
        branch.setForkPointer(1);

        BNBResult result = bnb.process(branch, Long.MAX_VALUE);

        assertEquals(13L ,result.getlMetric().longValue());

    }
}