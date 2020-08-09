package com.tushar.dsa.graphs.algorithms.chinese_postman_problem;

import com.tushar.dsa.graphs.core.graph_ds_with_edges.Edge;
import com.tushar.dsa.graphs.core.graph_ds_with_edges.Graph;
import com.tushar.dsa.graphs.core.graph_ds_with_edges.Vertex;

import java.util.*;

public class HierholzerAlgorithmEulerianCycle {
    Stack<Vertex> stack1 = new Stack<>();
    Stack<Vertex> stack2 = new Stack<>();
    Set<Edge> visitedEdges = new HashSet<>();

    private boolean isEulerianCyclePossible(Graph graph) {

        for (Vertex v : graph.getVertices()) {
            if (v.getAdjacentEdgesList().size() % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    private void eulerianDfs(Vertex vertex) {
        stack1.push(vertex);
        System.out.println("added vertex(" + vertex + ")) to stack1");

        for (Edge e :
                vertex.getAdjacentEdgesList()) {
            if (!visitedEdges.contains(e)) {
                // mark the edge as visited
                visitedEdges.add(e);
                // also mark the opposite edge as visited (if A->B is visited, B->A is also visited)
                visitedEdges.add(e.getTargetVertex().getEdgeForTarget(e.getSourceVertex()));

                eulerianDfs(e.getTargetVertex());
            }
        }

        stack1.pop();
        stack2.push(vertex);
        System.out.println("No more unvisited edges for vertex[," + vertex + " ]moved it from stack1 to stack2");
    }

    public List<Vertex> findEulerianCycle(Graph graph, Vertex source) {

        List<Vertex> eulerianPath = new ArrayList<>();

        if (!isEulerianCyclePossible(graph)) {
            return eulerianPath;
        }

        eulerianDfs(source);

        while (!stack2.isEmpty()) {
            eulerianPath.add(stack2.pop());
        }

        return eulerianPath;
    }

}
