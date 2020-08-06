package com.tushar.interviews;

/*
Question:
1. You are given a set of wires, with different lengths.
2. Cost of connecting any 2 wires is equal to sum of their lengths
3. Any 2 wires can be connected, either from the original ones, or the ones formed by connecting other wires
Eg. [1,4,2,7,8]
1+4 = 5
now it becomes:
[5,2,7,8]

Now keep doing it till there's only one wire left.
*/

/*
Solution:

1. It an be done with a greedy approach.
2. The key is that we have to connect 2 smallest possible wires at any stage, to keep the overall cost low.
3. So I will use a min heap, and will always take 2 smallest wires from the heap,
 and will push the new wire to the heap as well.
 */

import java.util.PriorityQueue;

public class ConnectWiresWithLeastCost {
    public static int findLowestPossibleCost(int[] wireLengths) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

//        Collections.addAll(minHeap, Arrays.asList(wireLengths));

        for (int wireLen :
                wireLengths) {
            minHeap.add(wireLen);
        }

        int cost = 0;

        while (!minHeap.isEmpty()) {
            int a = minHeap.remove();
            int c;
            if (!minHeap.isEmpty()) {
                int b = minHeap.remove();
                c = a + b;
                minHeap.add(c);
            } else {
                c = a;
            }
            cost += c;
        }

        return cost;
    }

    public static void main(String[] args) {
        int[] wires = {13, 5, 6, 7, 1, 9, 2};

        System.out.println("cost: " + findLowestPossibleCost(wires));
    }
}
