package com.tushar.practice.graphs.traversal;

import com.tushar.practice.graphs.common.Vertex;
import com.tushar.practice.graphs.graphDS.SimpleGraph;

public class App {
    public static void main(String[] args) {

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

