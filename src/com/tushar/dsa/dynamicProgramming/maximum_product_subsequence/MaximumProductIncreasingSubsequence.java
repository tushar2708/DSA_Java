package com.tushar.dsa.dynamicProgramming.maximum_product_subsequence;

import java.util.Arrays;

public class MaximumProductIncreasingSubsequence {
    public static int mpis(int[] arr) {

        int[] mssArray = Arrays.copyOf(arr, arr.length);

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {

                // we only look for sum, if these 2 follow increasing order
                if (arr[j] < arr[i]) {
                    // does adding this number to previous sum improve the sum?
                    mssArray[i] = Math.max(mssArray[i], arr[i] * mssArray[j]);
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for (int num : mssArray) {
            max = Math.max(max, num);
        }

        return max;
    }
}
