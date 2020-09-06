package com.tushar.dsa.arrays.find_duplicates_without_extra_space_in_linear_time;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-all-duplicates-in-an-array/submissions/
// Special condition: all array elements' values are b/w 1 to n (size of array)
// ie. 1 ≤ a[i] ≤ n
// This is why we can use the same array to store seen information
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i< nums.length; i++){

            int j = Math.abs(nums[i]) - 1;

            // negative value at index j means that j+1 is already seen
            if (nums[j] < 0){
                ans.add(j+1);
            }

            // this is the key step. whenever we see a number nums[i],
            // we make value at its corresponding index j, as a negative number
            // this way, we retain both original key, and seen information
            nums[j] = - nums[j];
        }

        return ans;
    }
}
