package com.tushar.dsa.arrays.zero_sum_array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {

    @Test
    public void sumZero() {
        int[] x = new Solution().sumZero(4);
        int[] y = new Solution().sumZero(5);

        Assert.assertEquals(0, Arrays.stream(x).sum());
        Assert.assertEquals(0, Arrays.stream(y).sum());
    }
}
