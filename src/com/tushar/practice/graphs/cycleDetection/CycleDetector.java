package com.tushar.practice.graphs.cycleDetection;

import com.tushar.practice.graphs.common.Vertex;
import com.tushar.practice.graphs.graphDS.SimpleGraph;

import java.util.HashSet;
import java.util.Set;

public class CycleDetector {

    private Set<Vertex> visited;
    private Set<Vertex> beingVisited;

    public CycleDetector() {
        visited = new HashSet<>();
        beingVisited = new HashSet<>();
    }

    private void dfs(Vertex current) throws Exception {
        visited.add(current);
        beingVisited.add(current);
        System.out.println("Started visiting vertex: " + current);


        // First visit all the neighbours recursively
        for (Vertex next :
                current.getAdjacencyList()) {

            // If any of the neighbours, is already being visited,
            // then we have hit a cycle.
            if (beingVisited.contains(next)) {
                System.out.println("Found cycle with vertex. current: " + current + ", next: " + next);
                throw new Exception("Found cycle with vertex: " + current);
            }

            if (!visited.contains(next)) {
                dfs(next);
            }
        }

        // Then finally put this vertex to a stack
        // So that the vertex with no outgoing edges,
        // will end up being on the bottom of the stack
        System.out.println("done visiting vertex: " + current);
        beingVisited.remove(current);
    }

    public boolean hasCycle(SimpleGraph graph) {

        for (Vertex vtx : graph.getVertices()) {
            if (!visited.contains(vtx)) {
                try {
                    dfs(vtx);
                } catch (Exception e) {
                    return true;
                }
            }
        }
        return false;
    }

}
