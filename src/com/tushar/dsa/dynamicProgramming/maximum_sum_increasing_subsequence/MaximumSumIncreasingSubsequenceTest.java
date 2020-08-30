package com.tushar.dsa.dynamicProgramming.maximum_sum_increasing_subsequence;

import org.junit.Assert;
import org.junit.Test;

public class MaximumSumIncreasingSubsequenceTest {

    @Test
    public void mss() {
        Assert.assertEquals(106, MaximumSumIncreasingSubsequence.msis(new int[]{1, 101, 2, 3, 100, 4, 5}));
    }
}
