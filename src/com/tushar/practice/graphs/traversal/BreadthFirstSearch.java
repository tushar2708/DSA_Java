package com.tushar.practice.graphs.traversal;

import com.tushar.practice.graphs.common.Vertex;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    public void traverse(Vertex root) {
        Queue<Vertex> queue = new LinkedList<>();

        root.setVisited(true);
        queue.add(root);

        while (!queue.isEmpty()) {
            Vertex current = queue.remove();
            System.out.print(current + " ");
            current.setVisited(true);

            for (Vertex next : current.getAdjacencyList()) {
                if (!next.getVisited()) {
                    queue.add(next);
                }
            }
        }

        System.out.println();

    }
}
