package com.tushar.dsa.graphs.algorithms.dfs_mazeSolve;

import com.tushar.dsa.graphs.core.simple_graph_ds.SimpleVertex;

import java.util.Deque;

public class MazeSolver {

    private Deque<SimpleVertex> stack;
    private int[][] mazeMap;
    private boolean[][] visited;


    public boolean findAWayOut(int[][] mazeMap) {
        this.mazeMap = mazeMap;
        this.visited = new boolean[mazeMap.length][mazeMap[0].length];

        // Step 1. start DFS from the starting point.
        try {
            dfs(0, 0);
        } catch (RuntimeException re) {
            return true;
        }

        return false;
    }

    private void dfs(int rowIndex, int columnIndex) throws RuntimeException {

//        System.out.println("Visiting: [" + rowIndex + "][" + columnIndex + "]");

        int maxIndex = mazeMap.length - 1;

        // Step 2, base 1: is out of map?
        if (rowIndex < 0 || rowIndex > maxIndex) {
            return;
        }

        // Step 2, base 2: is out of map?
        if (columnIndex < 0 || columnIndex > maxIndex) {
            return;
        }

        // Step 2, base 3: if cell has value 1, then it's a wall, we must back-track
        if (mazeMap[rowIndex][columnIndex] == 1) {
            return;
        }

        // Step 2, base 4: if cell has value 3, then it's the exit door
        if (mazeMap[rowIndex][columnIndex] == 3) {
            throw new RuntimeException("found the exit");
        }

        // Step 2, base 5: if visited, we can skip it
        if (visited[rowIndex][columnIndex]) {
            return;
        }

        // Step 3: Mark node as visited
        visited[rowIndex][columnIndex] = true;

        // Step 4: Visit all the neighbours recursively
        dfs(rowIndex - 1, columnIndex);      // left
        dfs(rowIndex + 1, columnIndex);     // right
        dfs(rowIndex, columnIndex + 1);   // up
        dfs(rowIndex, columnIndex - 1);  // down
    }
}
