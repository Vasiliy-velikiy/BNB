package PlantTests;

import com.datart.it.leaders.core.lib.model.parts.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class AssemblingLineTest {

    @Test
    public void AsmLineOk() {

        Work work1 = new Work(1, 14);
        Work work2 = new Work(2, 3);
        Work work3 = new Work(3, 6);

        PartType pt1 = new PartType(1);
        pt1.workflow = new ArrayList<Work>();
        pt1.workflow.add(work1);

        PartType pt2 = new PartType(3);
        pt2.workflow = new ArrayList<Work>();
        pt2.workflow.add(work3);
        pt2.workflow.add(work2);

        PartType pt3 = new PartType(4);
        pt3.workflow = new ArrayList<Work>();
        pt3.workflow.add(work2);
        pt3.workflow.add(work3);
        pt3.workflow.add(work1);

        Part part1 = new Part(1, pt1);
        Part part2 = new Part(2, pt1);
        Part part3 = new Part(3, pt2);
        Part part4 = new Part(4, pt3);

        /*List<Part> pl = new ArrayList<>();
        pl.add(part1);
        pl.add(part2);
        pl.add(part3);
        pl.add(part4);
        */

        AssemblingLine as1 = new AssemblingLine(1);
        as1.addPart(part1);
        as1.addPart(part2);
        as1.addPart(part3);
        as1.addPart(part4);

        as1.Process(30);
        assertEquals(part1, as1.Process(15));
    }
}



