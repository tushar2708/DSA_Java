package com.tushar.dsa.dynamicProgramming.longest_increasing_subsequence;

import org.junit.Test;

public class LongestIncreasingSubsequenceTest {

    @Test
    public void test1() {
        int longest = new LongestIncreasingSubsequence().longestIncreasingSubsequence(new int[]{3, 4, -1, 0, 6, 2, 3});
        System.out.println("longest: " + longest);
    }

    @Test
    public void test2() {
        int longest = new LongestIncreasingSubsequence().longestIncreasingSubsequence(new int[]{2, 5, 1, 8, 3});
        System.out.println("longest: " + longest);
    }
}
