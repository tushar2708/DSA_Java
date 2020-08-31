package com.tushar.dsa.arrays.reverse_engineer;

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
                {new int[]{17,13,11,2,3,5,7},new int[]{2,13,3,11,5,17,7}},
        });
    }

    private final int[] input;
    private final int[] expected;

    public SolutionTest(final int[] input,final int[] expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void deckRevealedIncreasing() {
        int[] actual = new Solution().deckRevealedIncreasing(input);
        Assert.assertArrayEquals(expected, actual);
    }
}
