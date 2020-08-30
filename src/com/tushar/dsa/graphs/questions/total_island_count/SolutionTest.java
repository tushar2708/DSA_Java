package com.tushar.dsa.graphs.questions.total_island_count;

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
                {new char[][]{{'1', '1', '0', '1', '1'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '1', '1'}, {'0', '0', '0', '1', '1'}}, 3},
                {new char[][]{{'1', '1', '1', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '1', '1'}, {'0', '0', '0', '1', '1'}}, 2},
        });
    }

    private final char[][] inputArray;
    private final int expected;

    public SolutionTest(final char[][] inputArray, final int expected) {
        this.inputArray = inputArray;
        this.expected = expected;
    }

    @Test
    public void maxAreaOfIsland() {
        int islandCount = new Solution().numIslands(inputArray);
        Assert.assertEquals(expected, islandCount);

    }
}
