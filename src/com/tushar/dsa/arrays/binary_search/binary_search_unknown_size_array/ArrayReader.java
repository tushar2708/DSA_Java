package com.tushar.dsa.arrays.binary_search.binary_search_unknown_size_array;

import java.util.Arrays;
import java.util.List;

public class ArrayReader {
    List<Integer> lst;

    public ArrayReader(Integer[] arr) {
        lst = Arrays.asList(arr);
    }

    public int get(int index) {
        if (index > lst.size() - 1) {
            return Integer.MAX_VALUE / 2 - 1;
        }

        return lst.get(index);
    }
}
