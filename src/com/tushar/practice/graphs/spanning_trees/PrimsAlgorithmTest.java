package com.tushar.practice.graphs.spanning_trees;

import com.tushar.practice.graphs.graph_ds_with_edges.Edge;
import com.tushar.practice.graphs.graph_ds_with_edges.Vertex;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PrimsAlgorithmTest {

    private List<Vertex> vertexList;
    private Vertex a;

    @Before
    public void makeGraph() {
        a = new Vertex("A");
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

        a.addNeighbour(ab);
        b.addNeighbour(ba);

        b.addNeighbour(bc);
        c.addNeighbour(cb);

        c.addNeighbour(cd);
        d.addNeighbour(dc);

        d.addNeighbour(da);
        a.addNeighbour(ad);

        vertexList = new ArrayList<>();

        vertexList.add(a);
        vertexList.add(b);
        vertexList.add(c);
        vertexList.add(d);
    }

    @Test
    public void getSpanningTreeLazy() {


        PrimsAlgorithm algorithm = new PrimsAlgorithm(vertexList);
        List<Edge> mst = algorithm.makePrimMSTLazy(a);

        System.out.println(mst);
    }

    @Test
    public void getSpanningTreeEager() {


        PrimsAlgorithm algorithm = new PrimsAlgorithm(vertexList);
        List<Edge> mst = algorithm.makePrimMSTEager(a);

        System.out.println(mst);
    }
}