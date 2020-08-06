package com.tushar.dsa.graphs.dfs_cycleDetection;

import com.tushar.dsa.graphs.graph_ds.SimpleVertex;
import com.tushar.dsa.graphs.graph_ds.SimpleGraph;
import org.junit.Assert;
import org.junit.Test;

public class CycleDetectorTest {

    @Test
    public void hasCycle() {
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
//        g.addNeighbour(a);        // uncommenting this will cause a cycle

        h.addNeighbour(g);

        CycleDetector cycleDetector = new CycleDetector();
        boolean hasCycle = cycleDetector.hasCycle(graph);
        System.out.println("graph has cycle?: " + hasCycle);

        Assert.assertFalse(hasCycle);
    }
}
