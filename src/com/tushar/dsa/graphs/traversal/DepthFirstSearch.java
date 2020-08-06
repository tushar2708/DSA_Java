package com.tushar.dsa.graphs.traversal;

import com.tushar.dsa.graphs.graph_ds.SimpleVertex;

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
