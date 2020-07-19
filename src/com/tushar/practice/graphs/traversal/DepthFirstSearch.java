package com.tushar.practice.graphs.traversal;

import com.tushar.practice.graphs.common.Vertex;

import java.util.HashSet;
import java.util.Set;

public class DepthFirstSearch implements TraversalStrategy {

    private Set<Vertex> visited;
    private boolean used;

    public DepthFirstSearch() {
        visited = new HashSet<>();
    }

    private void traverseRecur(Vertex current) {
        System.out.print(current + " ");
        visited.add(current);

        for (Vertex next : current.getAdjacencyList()) {
            if (!visited.contains(next)) {
                traverseRecur(next);
            }
        }
    }

    @Override
    public void traverse(Vertex root) throws Exception {

        if (used) throw new Exception("traverse already used, create new instance of DepthFirstSearch");
        used = true;

        traverseRecur(root);
    }
}
