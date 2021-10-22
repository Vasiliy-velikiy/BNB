package tests.node;

import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {

    private final List<Integer> transposition=Arrays.asList(1,2,3,4,5,6,7,8,9,0);
    private final Node instance=new  Node(0,1,transposition);

    @Test
    public void executeOK(){
        Node branch=fork(instance);
        List<Integer> expectedIntegerArray = Arrays.asList(1,3,2,4,5,6,7,8,9,0);
        assertEquals(branch.getArrayList(),repeatFirst);
    }

}