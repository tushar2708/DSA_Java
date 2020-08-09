package com.tushar.dsa.graphs.algorithms.traversal;

import com.tushar.dsa.graphs.core.simple_graph_ds.SimpleVertex;

import java.util.HashSet;
import java.util.Set;

public class DepthFirstSearch implements TraversalStrategy {

    private Set<SimpleVertex> visited;
    private boolean used;

    public DepthFirstSearch() {
        visited = new HashSet<>();
    }

    private void traverseRecur(SimpleVertex current) {
        System.out.print(current + " ");
        visited.add(current);

        for (SimpleVertex next : current.getAdjacencyList()) {
            if (!visited.contains(next)) {
                traverseRecur(next);
            }
        }
    }

    @Override
    public void traverse(SimpleVertex root) throws Exception {

        if (used) throw new Exception("traverse already used, create new instance of DepthFirstSearch");
        used = true;

        traverseRecur(root);
    }
}
