package com.tushar.dsa.arrays.modified_binary_search;

public class Solution {

    public int next(int[] nums, int index) {
        return (nums.length + ++index) % nums.length;
    }

    public int prev(int[] nums, int index) {
        return (nums.length + --index) % nums.length;
    }

    public int binarySearch(int[] nums, int target, int start, int end) {
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        // try to narrow down to inversion point in O(log(n))
        while (start <= end) {

            int mid = (start + end) / 2;

            // if we are lucky, we may also find our number while doing this. Cool
            if (nums[mid] == target) {
                return mid;

            } else if (nums[mid] < nums[nums.length - 1]) {
                // no point in checking on the right of mid,
                // bcz it's all sorted there
                end = mid - 1;

            } else {
                // if this mid number is greater than last,
                // then all is sorted on it's left. LEts ignore that part
                start = mid + 1;
            }
        }

        // start & end above will merge on the inversion point
        int inversionPoint = end;

        if (target > nums[nums.length - 1] && target < nums[inversionPoint]) {
            return binarySearch(nums, target, 0, inversionPoint);
        } else {
            return binarySearch(nums, target, inversionPoint, nums.length - 1);
        }

    }
}

// (7 + 3 - 4) % 7
