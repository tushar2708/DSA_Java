package com.tushar.dsa.graphs.algorithms.traversal;

import com.tushar.dsa.graphs.core.simple_graph_ds.SimpleVertex;

public interface TraversalStrategy {
    void traverse(SimpleVertex root) throws Exception;
}
