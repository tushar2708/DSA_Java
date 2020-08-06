package com.tushar.dsa.graphs.traversal;

import com.tushar.dsa.graphs.graph_ds.SimpleVertex;

public interface TraversalStrategy {
    void traverse(SimpleVertex root) throws Exception;
}
