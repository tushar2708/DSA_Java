package com.tushar.dsa.arrays.flip_an_image;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void sumZero() {

        int[][] y = new Solution().flipAndInvertImage(new int[][]{
                {1, 1, 0,},
                {1, 0, 1,},
                {0, 0, 0,}
        });

        Assert.assertArrayEquals(new int[][]{
                {1, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        }, y);
    }
}
