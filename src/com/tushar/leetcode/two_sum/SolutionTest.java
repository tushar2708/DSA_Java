package com.tushar.leetcode.two_sum;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {

    @Test
    public void twoSum() {
        int[] query = new int[]{2, 7, 11, 15};
        assertArrayEquals(new Solution().twoSum(query, 9), new int[]{0, 1});
    }
}
