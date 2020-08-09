package com.tushar.dsa.graphs.algorithms.strongly_connected_components;

import com.tushar.dsa.graphs.core.graph_ds_with_edges.Graph;
import com.tushar.dsa.graphs.core.graph_ds_with_edges.Vertex;
import org.junit.Before;
import org.junit.Test;

public class KosarajuTest {

    Graph graph = new Graph();
    Vertex source = null;

    @Before
    public void setUp() {

        graph = new Graph();

        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        Vertex g = new Vertex("G");
        Vertex h = new Vertex("H");
        Vertex i = new Vertex("I");
        Vertex j = new Vertex("J");
        Vertex k = new Vertex("K");


        graph.addVertices(a, b, c, d, e, f, g, h, i, j, k);

        graph.addEdge(a, b, 1);
        graph.addEdge(b, c, 4);
        graph.addEdge(c, a, 3);

        graph.addEdge(b, d, 2);

        graph.addEdge(d, e, 1);
        graph.addEdge(e, f, 4);
        graph.addEdge(f, d, 3);

        graph.addEdge(g, f, 2);

        graph.addEdge(g, h, 1);
        graph.addEdge(h, i, 4);
        graph.addEdge(i, j, 3);
        graph.addEdge(j, g, 2);

        graph.addEdge(j, k, 1);

        source = b;

    }

    @Test
    public void stronglyConnectedComponents() {

        Kosaraju algo = new Kosaraju();
        algo.stronglyConnectedComponents(graph, source);
    }
}
