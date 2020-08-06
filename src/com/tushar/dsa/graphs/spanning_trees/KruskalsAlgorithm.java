package com.tushar.dsa.graphs.spanning_trees;

import com.tushar.dsa.graphs.graph_ds_with_edges.Edge;
import com.tushar.dsa.graphs.graph_ds_with_edges.Vertex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalsAlgorithm {
    public List<Edge> getSpanningTree(List<Edge> edges) {

        Collections.sort(edges);

        List<Edge> minimumSpanningTree = new ArrayList<>();

        for (Edge edge : edges) {

            Vertex u = edge.getSourceVertex();
            Vertex v = edge.getTargetVertex();

            if (u.getDisjointSetNode().find() != v.getDisjointSetNode().find()) {

                System.out.println("merging " + u.getName() + " with " + v.getName());

                u.getDisjointSetNode().union(v.getDisjointSetNode());
                minimumSpanningTree.add(edge);

            } else {
                System.out.println(u.getName() + " and " + v.getName() + " form a cycle");
            }
        }
        return minimumSpanningTree;
    }
}
