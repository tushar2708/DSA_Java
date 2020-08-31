package com.tushar.dsa.strings.all_unique_substrings;

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
                {"AAB", 8},
                {"AAABBC", 188},
                {"V", 1},
        });
    }

    private final String tiles;
    private final int expected;

    public SolutionTest(final String tiles,final int expected) {
        this.tiles = tiles;
        this.expected = expected;
    }

    @Test
    public void multiply() {
        int actual = new Solution().numTilePossibilities(tiles);
        Assert.assertEquals(expected, actual);
    }
}
