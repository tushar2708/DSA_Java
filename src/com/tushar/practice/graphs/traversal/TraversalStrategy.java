package com.tushar.practice.graphs.traversal;

import com.tushar.practice.graphs.common.Vertex;

public interface TraversalStrategy {
    void traverse(Vertex root) throws Exception;
}
