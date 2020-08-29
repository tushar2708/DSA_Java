package com.tushar.dsa.moving_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class KadanesAlgorithmMaxSumContiguousSubArray {
    public static void main(String[] args) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = null;
        try {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int count = 0;
            while (n-- > 0) {
                int x = 0;
                try {
                    x = Integer.parseInt(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (x % k == 0)
                    count++;
            }

            System.out.println(count);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
