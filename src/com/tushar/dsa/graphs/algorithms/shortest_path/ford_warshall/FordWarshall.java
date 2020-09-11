package com.tushar.dsa.graphs.algorithms.shortest_path.ford_warshall;

public class FordWarshall {

    public int[][] allPathShortestPath(int[][] graph) {

        if (graph.length == 0 || graph[0].length != graph.length) {
            throw new RuntimeException("empty graph or non-square graph not allowed");
        }

        int n = graph.length;

        int[][] dp = new int[n][n];
        int[][] next = new int[n][n];

        for (int i = 0; i < n; i++) {
            System.arraycopy(graph[i], 0, dp[i], 0, n);
            for (int j = 0; j < n; j++) {
                if (graph[i][j] != Integer.MAX_VALUE) {
                    next[i][j] = j;
                }
            }
        }


        // see, if we can reach from "i" to "j", in a smaller path, via another node "k"
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (safeSum(dp[i][k], dp[k][j]) < dp[i][j]) {
                        dp[i][j] = safeSum(dp[i][k], dp[k][j]);
                        next[i][j] = graph[i][k];
                    }
                }
            }
        }

        return dp;
    }

    private int safeSum(int a, int b) {
        if (a == Integer.MAX_VALUE || b == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return a + b;
    }

}
