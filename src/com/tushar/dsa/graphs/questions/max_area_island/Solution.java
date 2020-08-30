package com.tushar.dsa.graphs.questions.max_area_island;

public class Solution {

    // boolean[][] visited;
    /*
    Instead of using a separate "visited" matrix,
    we can use the existing matrix, by marking the visited cell as -1
     */

    private int dfs(int[][] grid, int i, int j) {

        // boundary of the graph
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return 0;
        }

        // not 0, or already visited (has -1?)
        if (grid[i][j] == 0 || grid[i][j] == -1) {
            return 0;
        }

        // mark as visited
        grid[i][j] = -1;

        return 1 + dfs(grid, i + 1, j) + dfs(grid, i, j + 1) + dfs(grid, i - 1, j) + dfs(grid, i, j - 1);

    }

    public int maxAreaOfIsland(int[][] grid) {

        // visited = new boolean[grid.length][grid[0].length];
        int maxArea = 0;

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        return maxArea;

    }
}
