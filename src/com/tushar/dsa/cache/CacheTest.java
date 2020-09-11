package com.tushar.dsa.cache;


import com.tushar.dsa.cache.eviction.LruEviction;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CacheTest {

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

    public CacheTest(final int[] inputArray, final int inputTarget, final int expected) {
        this.inputArray = inputArray;
        this.inputTarget = inputTarget;
        this.expected = expected;
    }

    @Test
    public void search() {

        Cache c = new Cache(2);
        c.setEvictionStrategy(new LruEviction(2));
        c.put(1,1);
        c.put(2,2);
        Assert.assertEquals(1, c.get(1));
        Assert.assertEquals(2, c.get(2));
        Assert.assertEquals(Integer.MIN_VALUE, c.get(3));   // no 3 present
        c.put(3,3);
        Assert.assertEquals(3, c.get(3));
        Assert.assertEquals(Integer.MIN_VALUE, c.get(1));   // 1 should have been evicted
    }
}
