package com.tushar.practice.graphs.dfs_cycleDetection;

import com.tushar.practice.graphs.common.Vertex;
import com.tushar.practice.graphs.graphDS.SimpleGraph;
import org.junit.Assert;
import org.junit.Test;

public class CycleDetectorTest {

    @Test
    public void hasCycle() {
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
        g.addNeighbour(a);        // uncommenting this will cause a cycle

        h.addNeighbour(g);

        CycleDetector cycleDetector = new CycleDetector();
        boolean hasCycle = cycleDetector.hasCycle(graph);
        System.out.println("grahp has cycle?: " + hasCycle);

        Assert.assertTrue(hasCycle);

    }

    @Test
    public void hasNoCycle() {
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
//        g.addNeighbour(a);        // uncommenting this will cause a cycle

        h.addNeighbour(g);

        CycleDetector cycleDetector = new CycleDetector();
        boolean hasCycle = cycleDetector.hasCycle(graph);
        System.out.println("graph has cycle?: " + hasCycle);

        Assert.assertFalse(hasCycle);
    }
}
