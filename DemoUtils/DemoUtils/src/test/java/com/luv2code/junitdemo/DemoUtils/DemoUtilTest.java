package com.luv2code.junitdemo.DemoUtils;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DemoUtilTest {

    @Test
    public void testEqualsAndNotEeqals(){
        //setup
        DemoUtils demoUtils = new DemoUtils();
        Integer expected = 6;
        Integer unExecpted =8;
        //execution
        int  actual = demoUtils.add(2,4);

        //assertion
        assertEquals(expected,actual);
        assertNotEquals(unExecpted,actual);
    }

    //another approach code minimise
    @Test
    public void testEqualsNotEquals_1(){
        //setup
        DemoUtils demoUtils = new DemoUtils();
        //Execution and assertion in singe line
        assertEquals(6,demoUtils.add(2,4));
        assertNotEquals(8,demoUtils.add(3,4));
    }

    @Test
    public void checkNullOrNotNull(){
      //setup and initialization
        DemoUtils demoUtils = new DemoUtils();
        String str = null;
        String str1 = "Should not be null";
        // execution and assertion
    assertNotNull(demoUtils.checkNull(str1));
    assertNull(demoUtils.checkNull(str));
    }

}
