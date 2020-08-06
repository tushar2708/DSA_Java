package com.tushar.leetcode.microsoft.zero_sum_array;

class Solution {
    public int[] sumZero(int n) {

        if(n == 1){
            return new int[]{0};
        }

        // <0,1,2,3,4,5>
        // [3,2,1,-1,-2,-3]

        // <0,1,2,3,4>
        // [2,1,0,-1,-2]

        int[] arr = new int[n];
        int a = (n/2) -1;
        int b = (n % 2 == 0) ? a + 1 : a + 2;
        int c = 1;
        for (int i=0; i<n/2; i++){
            arr[a--] = c;
            arr[b++] = -c;

            ++c;
        }
        return arr;
    }
}
