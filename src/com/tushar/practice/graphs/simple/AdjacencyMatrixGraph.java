package com.tushar.practice.graphs.simple;

import com.tushar.practice.graphs.common.Vertex;

public class AdjacencyMatrixGraph {

    private static int[][] adjacencyMatrix = {
            {1, 2, 4, 0},
            {0, 0, 0, 3},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
    };

    public static void main(String[] args) {

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                if (adjacencyMatrix[i][j] != 0) {
                    System.out.println("Edge with weight: " + adjacencyMatrix[i][j]);
                }
            }
        }

        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");

        a.addNeighbour(b);
        a.addNeighbour(c);
        b.addNeighbour(d);

        a.showNeighbours();
        b.showNeighbours();
        c.showNeighbours();
        d.showNeighbours();
    }
}
