package com.tushar.dsa.graphs.algorithms.chinese_postman_problem;

import com.tushar.dsa.graphs.core.graph_ds_with_edges.Graph;
import com.tushar.dsa.graphs.core.graph_ds_with_edges.Vertex;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class HierholzerAlgorithmEulerianCycleTest {

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

        graph.addVertices(a, b, c, d, e, f);

        graph.addEdge(a, b, 1);
        graph.addEdge(b, a, 1);

        graph.addEdge(a, c, 1);
        graph.addEdge(c, a, 1);

        graph.addEdge(b, d, 1);
        graph.addEdge(d, b, 1);

        graph.addEdge(c, d, 1);
        graph.addEdge(d, c, 1);

        graph.addEdge(b, e, 1);
        graph.addEdge(e, b, 1);

        graph.addEdge(d, e, 1);
        graph.addEdge(e, d, 1);

        graph.addEdge(b, f, 1);
        graph.addEdge(f, b, 1);

        graph.addEdge(d, f, 1);
        graph.addEdge(f, d, 1);

        source = a;

    }

    @Test
    public void stronglyConnectedComponents() {

        HierholzerAlgorithmEulerianCycle algo = new HierholzerAlgorithmEulerianCycle();
        List<Vertex> eulerianCycle = algo.findEulerianCycle(graph, source);

        System.out.println("eulerianCycle:\n" + eulerianCycle);
    }
}
