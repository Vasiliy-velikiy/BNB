package PlantTests;

import com.datart.it.leaders.core.lib.model.parts.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class AssemblingLineTest {
    @Test
        public void asmLineTest(){
        Work work1 = new Work(1, 14);
        Work work2 = new Work(2, 3);
        Work work3 = new Work(3, 6);

        PartType pt1 = new PartType(1);
        pt1.workflow = new ArrayList<Work>();
        pt1.workflow.add(work1);
        pt1.workflow.add(work2);

        PartType pt2 = new PartType(3);
        pt2.workflow = new ArrayList<Work>();
        pt2.workflow.add(work3);
        pt2.workflow.add(work2);

        PartType pt3 = new PartType(4);
        pt3.workflow = new ArrayList<Work>();
        pt3.workflow.add(work2);
        pt3.workflow.add(work3);
        pt3.workflow.add(work1);

        AssemblingLine as1 = new AssemblingLine(work1);

    }
}
