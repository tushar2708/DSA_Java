package com.tushar.dsa.graphs.simple;

import com.tushar.dsa.graphs.graph_ds.SimpleVertex;

public class AdjacencyListGraph {

    public static void main(String[] args) {

        SimpleVertex a = new SimpleVertex("A");
        SimpleVertex b = new SimpleVertex("B");
        SimpleVertex c = new SimpleVertex("C");
        SimpleVertex d = new SimpleVertex("D");

        a.addNeighbour(b);
        a.addNeighbour(c);
        b.addNeighbour(d);

        a.showNeighbours();
        b.showNeighbours();
        c.showNeighbours();
        d.showNeighbours();
    }
}
