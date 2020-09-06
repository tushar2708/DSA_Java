package com.tushar.dsa.arrays.binary_search.binary_search_unknown_size_array;

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
                {new Integer[]{0, 1, 2, 4, 5, 6, 7}, 4, 3},
                {new Integer[]{1, 3}, 3, 1},
                {new Integer[]{1, 3, 5}, 5, 2},
        });
    }

    private final Integer[] inputArray;
    private final int inputTarget;
    private final int expected;

    public SolutionTest(final Integer[] inputArray, final int inputTarget, final int expected) {
        this.inputArray = inputArray;
        this.inputTarget = inputTarget;
        this.expected = expected;
    }

    @Test
    public void search() {
        int foundIndex = new Solution().search(new ArrayReader(inputArray), inputTarget);
        Assert.assertEquals(expected, foundIndex);

    }
}
