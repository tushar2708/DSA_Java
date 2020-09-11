package com.tushar.dsa.graphs.algorithms.shortest_path.dijkstra;

import com.tushar.dsa.graphs.core.graph_ds_with_edges.Edge;
import com.tushar.dsa.graphs.core.graph_ds_with_edges.Vertex;
import org.junit.Test;

public class DijkstraAlgorithmTest {

    @Test
    public void getShortestPathTo() {

        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");

        a.addNeighbourEdge(new Edge(a, b, 1));
        a.addNeighbourEdge(new Edge(a, c, 3));
        b.addNeighbourEdge(new Edge(b, c, 1));

        DijkstraAlgorithm algorithm = new DijkstraAlgorithm();
        algorithm.computePaths(a);

        System.out.println(algorithm.getShortestPathTo(c));
    }
}
