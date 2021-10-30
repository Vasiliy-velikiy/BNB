package com.datart.it.leaders.core.lib.model.node;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialNumberSystemTest {
FactorialNumberSystem factorialNumberSystem=new FactorialNumberSystem();


    @Test
    void recoveryPermutationsOne() {
        FactorialNumberSystem factorialNumberSystem=new FactorialNumberSystem();

        String actual="ecdba";

        char[]mass2=factorialNumberSystem.recoveryPermutations("0010");
        String expected="";
        for (int i = 0; i <mass2.length ; i++) {
            expected=expected+mass2[i];
        }
        assertEquals(actual,expected);
    }

    @Test
    void recoveryPermutationsTwo() {
        FactorialNumberSystem factorialNumberSystem=new FactorialNumberSystem();

        String actual="acedb";

        char[]mass2=factorialNumberSystem.recoveryPermutations("4020");
        String expected="";
        for (int i = 0; i <mass2.length ; i++) {
            expected=expected+mass2[i];
        }
        assertEquals(actual,expected);
    }

    @Test  //(expected=NullPointerException.class)
    void recoveryPermutationsThree() {
        FactorialNumberSystem factorialNumberSystem=new FactorialNumberSystem();

        String actual="ecdba";

        char[]mass2=factorialNumberSystem.recoveryPermutations("001");
        String expected="";
        for (int i = 0; i <mass2.length ; i++) {
            expected=expected+mass2[i];
        }
        assertEquals(actual,expected);
    }

    @Test //(expected=NullPointerException.class)
    void recoveryPermutationsFour() {
        FactorialNumberSystem factorialNumberSystem=new FactorialNumberSystem();

        String actual="acedb";

        char[]mass2=factorialNumberSystem.recoveryPermutations("40202321");
        String expected="";
        for (int i = 0; i <mass2.length ; i++) {
            expected=expected+mass2[i];
        }
        assertEquals(actual,expected);
    }

}