package com.tushar.dsa.sorting.quick_sort;

import java.util.Random;

public class QuickSort {

    public int[] quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }


    public void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = partition(arr, start, end);
            System.out.println("final pivot: " + pivot + "(" + start + ", " + end + ")");
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
    }

    private int partition(int[] arr, int start, int end) {
        int i = start - 1;  // ending of subarray of items less than pivot
        int j = start;  // index moving from start to end, to move "less than pivot" items to left one-by-one

        int pivot = getRandomPivot(start, end); // picking the last element as the pivot
        System.out.println("initial pivot: " + pivot);

        while (j < pivot) {
            if (arr[j] < arr[pivot]) {
                // swap i & j, one more item moved to the "less than pivot" section
                swap(arr, ++i, j);
            }
            j++;
        }
        // swap the pivot with element right after "i"
        swap(arr, ++i, pivot);

        return i;   // "i" is the new pivot
    }

    private void swap(int[] arr, int i, int j) {

        if (i < 0 || j < 0) {
            return;
        }

        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private int getRandomPivot(int i, int j) {
        Random generator = new Random();
        return generator.nextInt(j-i) + i;
    }
}
