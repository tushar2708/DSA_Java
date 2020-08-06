package com.tushar.leetcode.two_sum;

import java.util.HashMap;
import java.util.Map;

class Solution {

    private Map<Integer, Integer> seen;

    public Solution() {
        seen = new HashMap<>();
    }

    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int toSearch = target - num;
            if (this.seen.containsKey(toSearch)) {
                int foundAtIndex = this.seen.get(toSearch);
                return new int[]{foundAtIndex, i};
            }
            this.seen.put(num, i);
        }
        return new int[]{};
    }
}
