package com.tushar.dsa.moving_window.smallest_substring_with_all_unique_characters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinSizedUniqueElementsSubarray {
    public int minLengthSa(char[] arr) {

        Set<Character> s = new HashSet<>();
        Map<Character, Integer> m = new HashMap<>();

        for (char x : arr) {        // O(n)
            s.add(x);
        }

        int start = 0;
        int end = 0;

        int minTillnow = arr.length;
        int uniqueSize = s.size();

        s = null;    //	 GC optimisation

        int size = 0;

        // TODO: check loop break
        while (true) {        //	O(n)

            // not yet found an answer
            while (uniqueSize > m.size() && end < arr.length) {

                if (m.containsKey(arr[end])) {
                    m.replace(arr[end], m.get(arr[end]) + 1);
                } else {
                    m.put(arr[end], 1);
                }

                size = end - start + 1;    //5
                System.out.println("1. start: " + start + ", end: " + end + ", size: " + size);
                System.out.println("1. uniqueSize: " + uniqueSize + ", mapSize: " + m.size() + ", map: " + m);

                end++;        // 13, 15
            }

            minTillnow = Math.min(minTillnow, size);    // 5
            System.out.println("1. minTillnow: " + minTillnow + ", start: " + start + ", end: " + end + ", size: " + size);


            // found the answer, start kicking off
            while (uniqueSize == m.size() && start < end) {

                if (m.containsKey(arr[start])) {
                    m.replace(arr[start], m.get(arr[start]) - 1);
                }

                if (m.get(arr[start]) == 0) {
                    m.remove(arr[start]);
                }

                // size calculation is intentionally different from previous one,
                //because "end" has already incremented one last time, before breaking from previous loop"
                size = end - start;

                System.out.println("2. start: " + start + ", end: " + end + ", size: " + size);
                System.out.println("2. uniqueSize: " + uniqueSize + ", mapSize: " + m.size() + ", map: " + m);
                start++;        //13
            }

            minTillnow = Math.min(minTillnow, size);    // 4
            System.out.println("2. minTillnow: " + minTillnow + ", start: " + start + ", end: " + end + ", size: " + size);

            if (end >= arr.length) {
                break;
            }

        }
        return minTillnow;
    }
}
