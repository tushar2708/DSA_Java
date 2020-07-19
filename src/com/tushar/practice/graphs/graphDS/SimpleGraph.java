package com.tushar.practice.graphs.graphDS;

import com.tushar.practice.graphs.common.Vertex;
import com.tushar.practice.graphs.traversal.TraversalStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleGraph {

    private List<Vertex> vertices;
    private TraversalStrategy traversalStrategy;

    public SimpleGraph() {
        vertices = new ArrayList<>();
    }

    public void addVertices(Vertex... vxs) {
        vertices.addAll(Arrays.asList(vxs));
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public void setTraversalStrategy(TraversalStrategy traversalStrategy) {
        this.traversalStrategy = traversalStrategy;
    }

    public void traverse(Vertex source) throws Exception {
        traversalStrategy.traverse(source);
    }
}
