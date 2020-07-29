package com.tushar.practice.graphs.traversal;

import com.tushar.practice.graphs.graph_ds.SimpleVertex;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearch implements TraversalStrategy {

    Set<SimpleVertex> visited;
    Queue<SimpleVertex> queue;
    private boolean used;


    public BreadthFirstSearch() {
        visited = new HashSet<>();
    }

    @Override
    public void traverse(SimpleVertex root) throws Exception {

        if (used) throw new Exception("traverse already used, create new instance of BreadthFirstSearch");
        used = true;

        queue = new LinkedList<>();

        visited.add(root);
        queue.add(root);

        while (!queue.isEmpty()) {
            SimpleVertex current = queue.remove();
            System.out.print(current + " ");
            visited.add(current);

            for (SimpleVertex next : current.getAdjacencyList()) {
                if (!visited.contains(next)) {
                    queue.add(next);
                }
            }
        }

        System.out.println();

    }
}
