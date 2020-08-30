package com.tushar.dsa.arrays.sort_array_of_0_1_2;

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
                {new int[]{2, 0, 2, 1, 1, 0, 2}, new int[]{0, 0, 1, 1, 2, 2, 2}},
                {new int[]{1, 0, 2}, new int[]{0, 1, 2}},
        });
    }

    private final int[] input;
    private final int[] expected;

    public SolutionTest(final int[] input, final int[] expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void sortColors() {
        new Solution().sortColors(input);
        Assert.assertArrayEquals(expected, input);

    }
}
