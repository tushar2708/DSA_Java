package com.tushar.dsa.graphs.algorithms.shortest_path.ford_warshall;

import org.junit.Test;

public class FordWarshallTest {

    @Test
    public void allPathShortestPath() {

        int[][] graph = new int[][]{
                {0, 4, 1, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, 0, 6, Integer.MAX_VALUE},
                {4, 1, 0, 2},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0}
        };

        int[][] shortestPath = new FordWarshall().allPathShortestPath(graph);

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                System.out.print(shortestPath[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
