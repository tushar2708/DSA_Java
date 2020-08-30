package com.tushar.dsa.dynamicProgramming.maximum_product_subsequence;

import org.junit.Assert;
import org.junit.Test;

public class MaximumProductIncreasingSubsequenceTest {

    @Test
    public void mpis1() {
        Assert.assertEquals(45000, MaximumProductIncreasingSubsequence.mpis(new int[]{3, 100, 4, 5, 150, 6 }));
    }

    @Test
    public void mpis2() {
        Assert.assertEquals(21780000, MaximumProductIncreasingSubsequence.mpis(new int[]{10, 22, 9, 33, 21, 50, 41, 60}));
    }
}
