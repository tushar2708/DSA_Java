package com.tushar.dsa.arrays.sort_array_of_0_1_2;

// https://leetcode.com/problems/sort-colors/
public class Solution {
    public void sortColors(int[] nums) {
        int zeroEnd = 0;
        int twoStart = nums.length - 1;

        for(int i = 0; i < nums.length; i++){
            if (nums[i] == 0 && i > zeroEnd){
                int temp = nums[zeroEnd];
                nums[zeroEnd] = nums[i];
                nums[i] = temp;
                i = Math.min(i, zeroEnd) - 1;
                zeroEnd ++;
                continue;
            }

            if (nums[i] == 2 && i < twoStart){
                int temp = nums[twoStart];
                nums[twoStart] = nums[i];
                nums[i] = temp;
                i = Math.min(i, twoStart) - 1;
                twoStart --;
            }
        }
    }
}
