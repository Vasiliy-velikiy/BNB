package PlantTests;

import com.datart.it.leaders.core.lib.model.parts.Part;
import com.datart.it.leaders.core.lib.model.parts.PartType;
import com.datart.it.leaders.core.lib.model.parts.TransportLine;
import com.datart.it.leaders.core.lib.model.parts.Work;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TransportLineTest {
    TransportLine instance = new TransportLine();

    @Test
    void prepareOK() {
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


        List<Part> parts = Arrays.asList(new Part[]{part1, part2, part3, part4});

        instance.AddParts(parts);
        part2.currentWorkflow.remove(0);
        part3.currentWorkflow.remove(0);
        part4.currentWorkflow.remove(0);
        parts = Arrays.asList(new Part[]{part2, part3, part4});
        instance.Prepare();
        List<Part> tsLine = instance.getTsLine();
        Assert.assertEquals(tsLine, parts);
    }
}