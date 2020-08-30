package com.tushar.dsa.graphs.questions.max_area_island;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SolutionTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[][]{{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}}, 4},
                {new int[][]{{1, 1, 1, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}}, 5},
        });
    }

    private final int[][] inputArray;
    private final int expected;

    public SolutionTest(final int[][] inputArray, final int expected) {
        this.inputArray = inputArray;
        this.expected = expected;
    }

    @Test
    public void maxAreaOfIsland() {
        int maxArea = new Solution().maxAreaOfIsland(inputArray);
        Assert.assertEquals(expected, maxArea);

    }
}
