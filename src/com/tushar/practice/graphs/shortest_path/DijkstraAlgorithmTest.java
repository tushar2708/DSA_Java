package com.tushar.practice.graphs.shortest_path;

import com.tushar.practice.graphs.graph_ds_with_edges.Edge;
import com.tushar.practice.graphs.graph_ds_with_edges.Vertex;
import org.junit.Test;

public class DijkstraAlgorithmTest {

    @Test
    public void getShortestPathTo() {

        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");

        a.addNeighbour(new Edge(a, b, 1));
        a.addNeighbour(new Edge(a, c, 3));
        b.addNeighbour(new Edge(b, c, 1));

        DijkstraAlgorithm algorithm = new DijkstraAlgorithm();
        algorithm.computePaths(a);

        System.out.println(algorithm.getShortestPathTo(c));
    }
}
