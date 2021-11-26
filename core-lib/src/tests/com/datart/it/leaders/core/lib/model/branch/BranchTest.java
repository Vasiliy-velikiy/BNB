package com.datart.it.leaders.core.lib.model.branch;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class BranchTest {


@Test
   public void forkOK() {
        Branch branch =new Branch();
        List arr = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0})
                .boxed()
                .collect(Collectors.toList());
        branch.setSequence(arr);
        branch.setBase(0);
        branch.setForkPointer(1);
        Branch newBranch = branch.fork();
        assertEquals(newBranch.getBase(),1);
        assertEquals(newBranch.getForkPointer(),2);
        arr = Arrays.stream(new int[]{1, 3, 2, 4, 5, 6, 7, 8, 9, 0})
                .boxed()
                .collect(Collectors.toList());
        assertEquals(newBranch.getSequence(),arr);
    }

    @Test (expected =NullPointerException.class)
  public   void forkExcept() {
        Branch branch =new Branch();
        List arr = Arrays.stream(new int[]{1, 3, 2, 4, 5, 6, 7, 8, 9, 0})
                .boxed()
                .collect(Collectors.toList());
        branch.setSequence(arr);
        branch.setBase(10);
        branch.setForkPointer(10);
        Branch newBranch = branch.fork();
        assertEquals(newBranch.getBase(),10);
        assertEquals(newBranch.getForkPointer(),10);
        arr = Arrays.stream(new int[]{1, 3, 2, 4, 5, 6, 7, 8, 9, 0})
                .boxed()
                .collect(Collectors.toList());
        assertEquals(newBranch.getSequence(),arr);
    }
}


/*import org.junit.Assert;
        import org.junit.Before;
        import org.junit.Rule;
        import org.junit.Test;
        import static org.junit.Assert.assertEquals;
        import org.junit.rules.ExpectedException;
        import org.mockito.internal.matchers.Null;


        import java.util.Arrays;
        import java.util.LinkedList;
        import java.util.List;
        import java.util.stream.Collectors;*/


