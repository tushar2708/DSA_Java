package com.tushar.dsa.arrays.reverse_engineer;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// https://leetcode.com/problems/reveal-cards-in-increasing-order/
public class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {

        Arrays.sort(deck);

        Deque<Integer> dq = new ArrayDeque<>(deck.length);

        for(int i = deck.length-1; i >= 0; i--){
            if (!dq.isEmpty()){
                dq.addFirst(dq.removeLast());
            }
            dq.addFirst(deck[i]);
        }

        for(int i = deck.length-1; i >= 0; i--){
            deck[i] = dq.removeLast();
        }
        return deck;
    }
}
