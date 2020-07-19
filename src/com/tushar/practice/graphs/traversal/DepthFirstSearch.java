package com.tushar.practice.graphs.traversal;

import com.tushar.practice.graphs.common.Vertex;

public class DepthFirstSearch {

    public void traverse(Vertex root) {

        System.out.print(root + " ");
        root.setVisited(true);

        for (Vertex next : root.getAdjacencyList()) {
            if (!next.getVisited()) {
                traverse(next);
            }
        }
    }
}
