package com.tushar.dsa.graphs.algorithms.min_cut_and_max_flow;

import com.tushar.dsa.graphs.core.flow_graph_ds.FlowGraph;
import com.tushar.dsa.graphs.core.flow_graph_ds.FlowVertex;
import org.junit.Before;
import org.junit.Test;

public class FordFulkersonMaxFlowAlgoTest {

    FlowGraph graph = new FlowGraph();
    FlowVertex source = null;
    FlowVertex target = null;

    @Before
    public void setUp() {

        graph = new FlowGraph();

        FlowVertex a = new FlowVertex("A");
        FlowVertex b = new FlowVertex("B");
        FlowVertex c = new FlowVertex("C");
        FlowVertex d = new FlowVertex("D");
        FlowVertex e = new FlowVertex("E");
        FlowVertex f = new FlowVertex("F");
        FlowVertex g = new FlowVertex("G");


        graph.addVertices(a, b, c, d, e, f, g);

        graph.addEdge(a, b, 1, 3, 0);
        graph.addEdge(a, d, 0, 3, 0);

        graph.addEdge(b, c, 4, 4, 0);

        graph.addEdge(c, a, 3, 3, 0);
        graph.addEdge(c, d, 2, 1, 0);
        graph.addEdge(c, e, 2, 2, 0);

        graph.addEdge(d, e, 1, 2, 0);
        graph.addEdge(d, f, 4, 6, 0);

        graph.addEdge(e, b, 4, 1, 0);
        graph.addEdge(e, g, 4, 1, 0);

        graph.addEdge(f, g, 3, 9, 0);

        source = a;
        target = g;
    }

    @Test
    public void stronglyConnectedComponents() {

        FordFulkersonMaxFlowAlgo algo = new FordFulkersonMaxFlowAlgo();
        double maxFlow = algo.findMaxFlow(graph, source, target);

        System.out.println("maxFlow: " + maxFlow);
    }

}
