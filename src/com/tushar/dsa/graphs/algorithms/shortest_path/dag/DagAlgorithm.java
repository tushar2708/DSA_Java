package com.tushar.dsa.graphs.algorithms.shortest_path.dag;

import com.tushar.dsa.graphs.core.graph_ds_with_edges.Edge;
import com.tushar.dsa.graphs.core.graph_ds_with_edges.Vertex;

import java.util.*;

public class DagAlgorithm {


    private Deque<Vertex> stack;
    private Set<Vertex> visited;


    private void dfs(Vertex current) {
        visited.add(current);

        // First visit all the neighbours recursively
        for (Edge edge :
                current.getAdjacentEdgesList()) {
            if (!visited.contains(edge.getTargetVertex())) {
                dfs(edge.getTargetVertex());
            }
        }

        // Then finally put this PathVertex to a stack
        // So that the PathVertex with no outgoing edges,
        // will end up being on the bottom of the stack
        stack.push(current);
    }

    public DagAlgorithm() {
        stack = new ArrayDeque<>();
        visited = new HashSet<>();
    }

    public List<Vertex> sort(List<Vertex> vertices) {

        List<Vertex> sorted = new ArrayList<>();

        if (vertices.isEmpty()) {
            return sorted;
        }

        dfs(vertices.get(0));

        // Empty the stack and populate the list (order will be reversed)
        while (!stack.isEmpty()) {
            sorted.add(stack.pop());
        }

        return sorted;
    }

    public void computePaths(List<Vertex> vertices, Vertex source) {

        // sort topologically
        List<Vertex> tpSorted = sort(vertices);

        source.setDistance(0);

        // relax all the neighbours of vertices
        for (Vertex u : tpSorted) {
            for (Edge edge : u.getAdjacentEdgesList()) {
                Vertex v = edge.getTargetVertex();
                double newDistance = u.getDistance() + edge.getWeight();
                if (newDistance < v.getDistance()){
                    v.setDistance(newDistance);
                    v.setPredecessor(u);
                }
            }
        }
    }

    public List<Vertex> getShortestPathTo(Vertex targetPathVertex) {
        List<Vertex> shortestPathToTarget = new ArrayList<>();

        for (Vertex pathVertex = targetPathVertex; pathVertex != null; pathVertex = pathVertex.getPredecessor()) {
            shortestPathToTarget.add(0, pathVertex);
        }

        return shortestPathToTarget;
    }

}
