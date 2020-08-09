package com.tushar.dsa.graphs.algorithms.dfs_topologicalSort;

import com.tushar.dsa.graphs.core.simple_graph_ds.SimpleVertex;
import com.tushar.dsa.graphs.core.simple_graph_ds.SimpleGraph;

import java.util.*;

public class TopologicalSorter {

    private Deque<SimpleVertex> stack;
    private Set<SimpleVertex> visited;


    private void dfs(SimpleVertex current) {
        visited.add(current);

        // First visit all the neighbours recursively
        for (SimpleVertex next :
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

    public List<SimpleVertex> sort(SimpleGraph graph) {

        List<SimpleVertex> sorted = new ArrayList<>();

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
