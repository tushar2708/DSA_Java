package com.tushar.practice.graphs.spanning_trees;

import com.tushar.practice.graphs.graph_ds_with_edges.Edge;
import com.tushar.practice.graphs.graph_ds_with_edges.Vertex;

import java.util.*;

public class PrimsAlgorithm {
    private List<Vertex> vertices; // actual vertices of the graph

    public PrimsAlgorithm(List<Vertex> vertices) {
        this.vertices = vertices;
    }

    public List<Edge> makePrimMSTLazy(Vertex vertex) {

        Set<Vertex> visitedVertices = new HashSet<>();
        List<Edge> spanningTree = new ArrayList<>();
        PriorityQueue<Edge> edgeMinHeap = new PriorityQueue<>();    // a min heap to keep track of minimum weight edges


        // repeat unless all vertices are visitedVertices.
        while (visitedVertices.size() < this.vertices.size()) {

            for (Edge edge : vertex.getAdjacentEdgesList()) {
                // mark vertex as visitedVertices
                visitedVertices.add(vertex);

//                System.out.println("picked vertex:" + vertex + ", edge:" + edge + "\nvisitedVertices:" + visitedVertices);

                // Only add an edge to heap if it's target vertex is not already visitedVertices.
                // This is to ensure that there is no cycle.
                if (!visitedVertices.contains(edge.getTargetVertex())) {
                    edgeMinHeap.add(edge);
                }

                if (edgeMinHeap.isEmpty()) {
                    continue;
                }

                // add the next smallest edge, that is seen (bcz, greedy) to spanning tree
                Edge minEdge = edgeMinHeap.remove();
                spanningTree.add(minEdge);
                System.out.println("Added minEdge to MST:" + minEdge);

//                this.totalCost += minEdge.getWeight();

                // Set the target vertex of the minimum cost edge as the new vertex
                vertex = minEdge.getTargetVertex();
            }
        }

        return spanningTree;
    }

    public List<Edge> makePrimMSTEager(Vertex vertex) {
        Set<Vertex> visitedVertices = new HashSet<>();
        List<Edge> spanningTree = new ArrayList<>();
        Map<Vertex, Edge> minEdgeMap = new HashMap<>();
        PriorityQueue<Vertex> vertexMinHeap = new PriorityQueue<>();    // a min heap to keep track of minimum weight edges

        // start by setting the min distance of the starting note as 0 (similar to shortest path )
        vertex.setDistance(0);
        vertexMinHeap.add(vertex);

        while (!vertexMinHeap.isEmpty()) {
            Vertex v = vertexMinHeap.remove();  // take vertex from heap
            visitedVertices.add(v); // mark vertex as visited

            for (Edge edge :
                    v.getAdjacentEdgesList()) {
                Vertex target = edge.getTargetVertex();

                if(visitedVertices.contains(target)){
                    continue;
                }

                if(edge.getWeight() < target.getDistance()){
                    target.setDistance(edge.getWeight());
                    minEdgeMap.put(target, edge);   // save the min cost edge to reach this vertex

                    if (vertexMinHeap.contains(target)){
                        vertexMinHeap.remove(target);   // remove any existing instance of this vertex from heap
                    }

                    vertexMinHeap.add(target);  // add updated version of this vertex
                }
            }
        }

        for (Vertex v :
                vertices) {
            spanningTree.add(minEdgeMap.get(v));
        }

        return spanningTree;
    }
}
