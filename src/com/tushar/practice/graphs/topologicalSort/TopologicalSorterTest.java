package com.tushar.practice.graphs.topologicalSort;

import com.tushar.practice.graphs.common.Vertex;
import com.tushar.practice.graphs.graphDS.SimpleGraph;
import org.junit.Test;

import java.util.List;

public class TopologicalSorterTest {

    @Test
    public void sort() {

        SimpleGraph graph = new SimpleGraph();


        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        Vertex g = new Vertex("G");
        Vertex h = new Vertex("H");

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
        List<Vertex> topSorted = sorter.sort(graph);
        System.out.println(topSorted);
    }
}
