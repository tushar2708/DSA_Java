package com.tushar.practice.graphs.shortest_path;

import com.tushar.practice.graphs.graph_ds_with_edges.Edge;
import com.tushar.practice.graphs.graph_ds_with_edges.Vertex;
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

        a.addNeighbour(ab);
        a.addNeighbour(ac);
        b.addNeighbour(bc);

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
