package com.tushar.dsa.arrays.binary_search.binary_search_unknown_size_array;

// https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size
public class Solution {
    public int search(ArrayReader reader, int target) {

        int end = 1;

        // First find the end of search range, by doubling from 1
        // With 10^4 size, it will take max 15 steps (2^14 ~= 16 k)
        while(reader.get(end) < target){
            end = end << 1;
        }

        // The previously rejected half value in the above process,
        // can be taken as "start"
        int start = end >> 1;

        // System.out.println("start: " + start + ", end: " + end);

        while(start <= end) {
            int mid = (start + end) / 2;
            // System.out.println("mid: " + mid);
            int midVal = reader.get(mid);
            if (midVal == target){
                return mid;
            } else if (target < midVal){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            // System.out.println("start: " + start + ", end: " + end);

        }


        return -1;
    }
}
