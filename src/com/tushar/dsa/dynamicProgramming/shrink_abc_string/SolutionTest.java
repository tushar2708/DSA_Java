package com.tushar.dsa.dynamicProgramming.shrink_abc_string;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void TestAba() {
        int minSize = new Solution().solution("aba");
        System.out.println("minSize: " + minSize);

        Assert.assertEquals(1, minSize);
    }

    @Test
    public void TestCab() {
        int minSize = new Solution().solution("cab");
        System.out.println("minSize: " + minSize);

        Assert.assertEquals(2, minSize);
    }

    @Test
    public void TestBcab() {
        int minSize = new Solution().solution("bcab");
        System.out.println("minSize: " + minSize);

        Assert.assertEquals(1, minSize);
    }

}
