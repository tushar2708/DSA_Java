package com.tushar.practice.graphs.traversal;

import com.tushar.practice.graphs.common.Vertex;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearch implements TraversalStrategy {

    Set<Vertex> visited;
    Queue<Vertex> queue;
    private boolean used;


    public BreadthFirstSearch() {
        visited = new HashSet<>();
    }

    @Override
    public void traverse(Vertex root) throws Exception {

        if (used) throw new Exception("traverse already used, create new instance of BreadthFirstSearch");
        used = true;

        queue = new LinkedList<>();

        visited.add(root);
        queue.add(root);

        while (!queue.isEmpty()) {
            Vertex current = queue.remove();
            System.out.print(current + " ");
            visited.add(current);

            for (Vertex next : current.getAdjacencyList()) {
                if (!visited.contains(next)) {
                    queue.add(next);
                }
            }
        }

        System.out.println();

    }
}
