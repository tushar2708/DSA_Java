package com.tushar.dsa.dynamicProgramming.longest_increasing_subsequence;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    int[] mem;

    public int longestIncreasingSubsequence(int[] arr) {

        // lets create an array of lis till a given index, and initialize it with 1 (min possible value of LIS)
        mem = new int[arr.length];
//        Arrays.fill(mem, 1);


        // recursion moves from 0 --> n, with (currIndex == n) being the base condition
        // sending minimum possible value as previous value, so that it's over-written by any number
//        int maxLen = lisRecur(arr, 0, Integer.MIN_VALUE);

        // iterative approach
        return lis(arr);
    }

    // lisRecur doesn't use any memoization
    public int lisRecur(int[] arr, int i, int prev) {
        // Base case: nothing is remaining
        if (i == arr.length) {
            return 0;
        }

//        if (mem[i] != 0){
//            return mem[i];
//        }

        // case 1: exclude the current element and process the
        // remaining elements
        int excluding = lisRecur(arr, i + 1, prev);

        // case 2: include the current element if it is greater
        // than previous element in LIS
        int including = 0;
        if (arr[i] > prev) {
            including = 1 + lisRecur(arr, i + 1, arr[i]);
        }

        // return maximum of above two choices
        mem[i] = Integer.max(including, excluding);
        return mem[i];
    }

    // Iterative function to find length of longest increasing subsequence of given array
    int lis(int arr[]) {
        int n = arr.length;
        // array to store sub-problem solution. L[i] stores the length
        // of the longest increasing subsequence ends with arr[i]
        mem = new int[n];
        Arrays.fill(mem, 1);

        // longest increasing subsequence ending with arr[0] has length 1
//        mem[0] = 1;

        // start from second element in the array
        for (int i = 1; i < n; i++) {
            // do for each element in subarray arr[0..i-1]
            for (int j = 0; j < i; j++) {
                // find longest increasing subsequence that ends with arr[j]
                // where arr[j] is less than the current element arr[i]
                if (arr[j] <= arr[i]) {
                    mem[i] = Math.max(1 + mem[j], mem[i]);
                }
            }
        }

        // akanksha- mem is your answer. Don't go below this line Print it in the given format
        for (int x : mem)
            System.out.print(x + " ");

        // find longest increasing subsequence (having maximum length)
        int lis = Integer.MIN_VALUE;
        for (int x : mem)
            lis = Math.max(lis, x);
        return lis;
    }


}
