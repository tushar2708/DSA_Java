package com.tushar.dsa.graphs.traversal;

import com.tushar.dsa.graphs.graph_ds.SimpleVertex;
import com.tushar.dsa.graphs.graph_ds.SimpleGraph;

public class App {
    public static void main(String[] args) {

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

        b.addNeighbour(a);
        b.addNeighbour(c);
        b.addNeighbour(d);

        c.addNeighbour(b);

        d.addNeighbour(b);
        d.addNeighbour(e);

        f.addNeighbour(a);

        g.addNeighbour(a);
        g.addNeighbour(h);

        h.addNeighbour(g);

        graph.setTraversalStrategy(new BreadthFirstSearch());
        try {
            graph.traverse(a);
        } catch (Exception exception) {
            graph.setTraversalStrategy(new BreadthFirstSearch());
            try {
                graph.traverse(a);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        graph.setTraversalStrategy(new DepthFirstSearch());
        try {
            graph.traverse(a);
        } catch (Exception exception) {
            graph.setTraversalStrategy(new BreadthFirstSearch());
            try {
                graph.traverse(a);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}

