package com.tushar.practice.graphs.traversal;

import com.tushar.practice.graphs.graph_ds.SimpleVertex;

public interface TraversalStrategy {
    void traverse(SimpleVertex root) throws Exception;
}
