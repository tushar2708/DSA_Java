package com.tushar.dsa.graphs.algorithms.dfs_mazeSolve;

import org.junit.Assert;
import org.junit.Test;

public class MazeSolverTest {

    @Test
    public void findAWayOut() {
        int[][] mazeMap = new int[][]{
                {0, 0, 1, 0},
                {1, 0, 1, 3},
                {0, 0, 1, 0},
                {1, 0, 0, 0},
        };

        MazeSolver solver = new MazeSolver();
        boolean found = solver.findAWayOut(mazeMap);
        System.out.println(found);
        Assert.assertTrue(found);
    }

    @Test
    public void noWayOut() {
        int[][] mazeMap = new int[][]{
                {0, 0, 1, 0},
                {1, 0, 1, 3},
                {0, 0, 1, 1},
                {1, 0, 0, 0},
        };

        MazeSolver solver = new MazeSolver();
        boolean found = solver.findAWayOut(mazeMap);
        System.out.println(found);
        Assert.assertFalse(found);
    }
}
