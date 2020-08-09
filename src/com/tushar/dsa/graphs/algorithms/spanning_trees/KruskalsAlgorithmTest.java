package com.tushar.dsa.graphs.algorithms.spanning_trees;

import com.tushar.dsa.graphs.core.graph_ds_with_edges.Edge;
import com.tushar.dsa.graphs.core.graph_ds_with_edges.Vertex;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class KruskalsAlgorithmTest {

    @Test
    public void getSpanningTree() {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");

        Edge ab = new Edge(a, b, 1);
        Edge bc = new Edge(b, c, 4);
        Edge cd = new Edge(c, d, 3);
        Edge da = new Edge(d, a, 2);
        Edge ba = new Edge(b, a, 1);
        Edge cb = new Edge(c, b, 4);
        Edge dc = new Edge(d, c, 3);
        Edge ad = new Edge(a, d, 2);

        a.addNeighbourEdge(ab);
        b.addNeighbourEdge(ba);

        b.addNeighbourEdge(bc);
        c.addNeighbourEdge(cb);

        c.addNeighbourEdge(cd);
        d.addNeighbourEdge(dc);

        d.addNeighbourEdge(da);
        a.addNeighbourEdge(ad);

        List<Edge> edgeList = new ArrayList<>();
        edgeList.add(ab);
        edgeList.add(ba);
        edgeList.add(bc);
        edgeList.add(cb);
        edgeList.add(cd);
        edgeList.add(dc);
        edgeList.add(da);
        edgeList.add(ad);

        KruskalsAlgorithm algorithm = new KruskalsAlgorithm();
        List<Edge> mst = algorithm.getSpanningTree(edgeList);

        System.out.println(mst);
    }
}
