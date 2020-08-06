package com.tushar.dsa.graphs.shortest_path;

import com.tushar.dsa.graphs.graph_ds_with_edges.Edge;
import com.tushar.dsa.graphs.graph_ds_with_edges.Vertex;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BellmanFordAlgorithmTest {

    @Test
    public void getShortestPathTo() {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
//        PathVertex d = new PathVertex("D");
//        PathVertex e = new PathVertex("E");
//        PathVertex f = new PathVertex("F");
//        PathVertex g = new PathVertex("G");
//        PathVertex h = new PathVertex("H");

//        graph.addVertices(a, b, c, d, e, f, g, h);

        Edge ab = new Edge(a, b, 1);
        Edge ac = new Edge(a, c, 1);
        Edge bc = new Edge(b, c, -3);
        Edge ca = new Edge(c, a, -3);

        a.addNeighbour(ab);
        a.addNeighbour(ac);
        b.addNeighbour(bc);
        b.addNeighbour(ca);

        List<Vertex> vertexList = new ArrayList<>();
        vertexList.add(a);
        vertexList.add(b);
        vertexList.add(c);

        List<Edge> edgeList = new ArrayList<>();
        edgeList.add(ab);
        edgeList.add(ac);
        edgeList.add(bc);
        edgeList.add(ca);

        BellmanFordAlgorithm algorithm = new BellmanFordAlgorithm(edgeList, vertexList);

        try {
            algorithm.computePaths(a);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println(algorithm.getShortestPathTo(c));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
