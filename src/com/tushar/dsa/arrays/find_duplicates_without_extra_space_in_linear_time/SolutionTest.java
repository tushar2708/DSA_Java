package com.tushar.dsa.arrays.find_duplicates_without_extra_space_in_linear_time;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class SolutionTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{4,3,2,7,8,2,3,1},new int[]{2,3}},
                {new int[]{10,2,5,10,9,1,1,4,3,7},new int[]{10,1}},
        });
    }

    private final int[] input;
    private final int[] expected;

    public SolutionTest(final int[] input, final int[] expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void deckRevealedIncreasing() {

        List<Integer> actualTemp = new Solution().findDuplicates(input);
        int[] actual = actualTemp.stream().mapToInt(i->i).toArray();
        Assert.assertArrayEquals(expected, actual);
    }
}
