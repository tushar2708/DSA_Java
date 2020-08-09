package com.tushar.dsa.graphs.algorithms.dfs_topologicalSort;

import com.tushar.dsa.graphs.core.simple_graph_ds.SimpleVertex;
import com.tushar.dsa.graphs.core.simple_graph_ds.SimpleGraph;
import org.junit.Test;

import java.util.List;

public class TopologicalSorterTest {

    @Test
    public void sort() {

        SimpleGraph graph = new SimpleGraph();

        SimpleVertex a = new SimpleVertex("A");
        SimpleVertex b = new SimpleVertex("B");
        SimpleVertex c = new SimpleVertex("C");
        SimpleVertex d = new SimpleVertex("D");
        SimpleVertex e = new SimpleVertex("E");
        SimpleVertex f = new SimpleVertex("F");
        SimpleVertex g = new SimpleVertex("G");
        SimpleVertex h = new SimpleVertex("H");

        graph.addVertices(a, b, c, d, e, f, g, h);

        a.addNeighbour(b);
        a.addNeighbour(f);
        a.addNeighbour(g);

        b.addNeighbour(c);
        b.addNeighbour(d);

        c.addNeighbour(e);

        d.addNeighbour(e);

        f.addNeighbour(h);

        g.addNeighbour(b);
        g.addNeighbour(a);

        h.addNeighbour(g);

        TopologicalSorter sorter = new TopologicalSorter();
        List<SimpleVertex> topSorted = sorter.sort(graph);
        System.out.println(topSorted);
    }
}
