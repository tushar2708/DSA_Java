package com.tushar.dsa.arrays.flip_an_image;

class Solution {
    public int[][] flipAndInvertImage(int[][] A) {

        for (int i = 0; i<A.length; i++){
            int[] arr = A[i];
            int n = arr.length;
            int j = 0;
            while (j < n/2){
                int a = arr[j];
                arr[j] = 1 - arr[n-1-j];
                arr[n-1-j] = 1-a;

                ++j;
            }

            if (n%2 != 0){
                arr[j] = 1 - arr[j];
            }
        }

        return A;

    }
}
