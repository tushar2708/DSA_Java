package com.tushar.dsa.graphs.algorithms.shortest_path.dag;

import com.tushar.dsa.graphs.core.graph_ds_with_edges.Edge;
import com.tushar.dsa.graphs.core.graph_ds_with_edges.Vertex;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DagAlgorithmTest {

    @Test
    public void getShortestPathTo() {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");

        Edge ab = new Edge(a, b, 1);
        Edge ac = new Edge(a, c, 3);
        Edge bc = new Edge(b, c, 1);

        a.addNeighbourEdge(ab);
        a.addNeighbourEdge(ac);
        b.addNeighbourEdge(bc);

        List<Vertex> vertexList = new ArrayList<>();
        vertexList.add(a);
        vertexList.add(b);
        vertexList.add(c);

        List<Edge> edgeList = new ArrayList<>();
        edgeList.add(ab);
        edgeList.add(ac);
        edgeList.add(bc);

        DagAlgorithm algorithm = new DagAlgorithm();
        algorithm.computePaths(vertexList, a);

        System.out.println(algorithm.getShortestPathTo(c));
    }
}
