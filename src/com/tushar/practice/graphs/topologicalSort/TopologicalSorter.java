package com.tushar.practice.graphs.topologicalSort;

import com.tushar.practice.graphs.common.Vertex;
import com.tushar.practice.graphs.graphDS.SimpleGraph;

import java.util.*;

public class TopologicalSorter {

    private Deque<Vertex> stack;
    private Set<Vertex> visited;


    private void dfs(Vertex current) {
        visited.add(current);

        // First visit all the neighbours recursively
        for (Vertex next :
                current.getAdjacencyList()) {
            if (!visited.contains(next)) {
                dfs(next);
            }
        }

        // Then finally put this vertex to a stack
        // So that the vertex with no outgoing edges,
        // will end up being on the bottom of the stack
        stack.push(current);
    }

    public TopologicalSorter() {
        stack = new ArrayDeque<>();
        visited = new HashSet<>();
    }

    public List<Vertex> sort(SimpleGraph graph) {

        List<Vertex> sorted = new ArrayList<>();

        if (graph.getVertices().isEmpty()) {
            return sorted;
        }

        dfs(graph.getVertices().get(0));

        // Empty the stack and populate the list (order will be reversed)
        while (!stack.isEmpty()) {
            sorted.add(stack.pop());
        }

        return sorted;
    }
}
