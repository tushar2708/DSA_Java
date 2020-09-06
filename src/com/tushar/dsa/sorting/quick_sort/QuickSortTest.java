package com.tushar.dsa.sorting.quick_sort;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class QuickSortTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{0, 7, 6, 5, 4, 2, 1}, new int[]{0, 1, 2, 4, 5, 6, 7}},
                {new int[]{1, 3, 2, 9, 7, 4}, new int[]{1, 2, 3, 4, 7, 9}},
                {new int[]{5, 3, 1}, new int[]{1, 3, 5}},
        });
    }

    private final int[] inputArray;
    private final int[] expectedArray;

    public QuickSortTest(final int[] inputArray, final int[] expectedArray) {
        this.inputArray = inputArray;
        this.expectedArray = expectedArray;
    }

    @Test
    public void quickSort() {
        int[] actualArray = new QuickSort().quickSort(inputArray);
        Assert.assertArrayEquals(expectedArray, actualArray);
    }
}
