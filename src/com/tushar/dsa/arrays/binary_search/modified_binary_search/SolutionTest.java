package com.tushar.dsa.arrays.binary_search.modified_binary_search;

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
                {new int[]{4, 5, 6, 7, 0, 1, 2}, 0, 4},
                {new int[]{1, 3}, 3, 1},
                {new int[]{3, 5, 1}, 3, 0},
        });
    }

    private final int[] inputArray;
    private final int inputTarget;
    private final int expected;

    public SolutionTest(final int[] inputArray, final int inputTarget, final int expected) {
        this.inputArray = inputArray;
        this.inputTarget = inputTarget;
        this.expected = expected;
    }

    @Test
    public void search() {
        int foundIndex = new com.tushar.dsa.arrays.binary_search.modified_binary_search.Solution().search(inputArray, inputTarget);
        Assert.assertEquals(expected, foundIndex);

    }
}
