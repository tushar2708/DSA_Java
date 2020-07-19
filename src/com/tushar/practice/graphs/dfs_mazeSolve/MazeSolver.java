package com.tushar.practice.graphs.dfs_mazeSolve;

import com.tushar.practice.graphs.common.Vertex;

import java.util.Deque;

public class MazeSolver {

    private Deque<Vertex> stack;
    private int[][] mazeMap;
    private boolean[][] visited;


    public boolean findAWayOut(int[][] mazeMap) {
        this.mazeMap = mazeMap;
        this.visited = new boolean[mazeMap.length][mazeMap[0].length];

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

        // is out of map?
        if (rowIndex < 0 || rowIndex > maxIndex) {
            return;
        }

        // is out of map?
        if (columnIndex < 0 || columnIndex > maxIndex) {
            return;
        }

        // if cell has value 1, then it's a wall, we must back-track
        if (mazeMap[rowIndex][columnIndex] == 1) {
            return;
        }

        // if cell has value 3, then it's the exit door
        if (mazeMap[rowIndex][columnIndex] == 3) {
            throw new RuntimeException("found the exit");
        }

        //if visited, we can skip it
        if (visited[rowIndex][columnIndex]) {
            return;
        }

        visited[rowIndex][columnIndex] = true;

        // Visit all the neighbours recursively
        dfs(rowIndex - 1, columnIndex);      // left
        dfs(rowIndex + 1, columnIndex);     // right
        dfs(rowIndex, columnIndex + 1);   // up
        dfs(rowIndex, columnIndex - 1);  // down
    }


}
