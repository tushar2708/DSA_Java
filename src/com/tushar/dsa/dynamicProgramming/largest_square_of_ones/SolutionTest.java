package com.tushar.dsa.dynamicProgramming.largest_square_of_ones;

import com.tushar.dsa.moving_window.smallest_substring_with_all_unique_characters.MinSizedUniqueElementsSubarray;
import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test1() {
        int ans = new Solution().largestSquareOfOnes(new int[][]{
                {0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
        });
        Assert.assertEquals(3, ans);
    }

    @Test
    public void test2() {
        int ans = new Solution().largestSquareOfOnes(new int[][]{
                {0, 1, 1, 0, 1},
                {1, 1, 0, 1, 1},
                {0, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
        });
        Assert.assertEquals(4, ans);
    }

}