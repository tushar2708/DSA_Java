package com.tushar.practice.graphs.graph_ds;

import com.tushar.practice.graphs.traversal.TraversalStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleGraph {

    private List<SimpleVertex> vertices;
    private TraversalStrategy traversalStrategy;

    public SimpleGraph() {
        vertices = new ArrayList<>();
    }

    public void addVertices(SimpleVertex... vxs) {
        vertices.addAll(Arrays.asList(vxs));
    }

    public List<SimpleVertex> getVertices() {
        return vertices;
    }

    public void setTraversalStrategy(TraversalStrategy traversalStrategy) {
        this.traversalStrategy = traversalStrategy;
    }

    public void traverse(SimpleVertex source) throws Exception {
        traversalStrategy.traverse(source);
    }
}
