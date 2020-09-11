package com.tushar.dsa.graphs.algorithms.shortest_path.dijkstra;

import com.tushar.dsa.graphs.core.graph_ds_with_edges.Edge;
import com.tushar.dsa.graphs.core.graph_ds_with_edges.Vertex;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {

    public void computePaths(Vertex source) {
        source.setDistance(0);

        //priority queue will have vertex with smallest distance on top
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(source);

        while (!priorityQueue.isEmpty()) {
            Vertex currentPathVertex = priorityQueue.poll();

            for (Edge edge :
                    currentPathVertex.getAdjacentEdgesList()) {
                Vertex v = edge.getTargetVertex();

                double newDistance = currentPathVertex.getDistance() + edge.getWeight();

                if (newDistance < v.getDistance()) {

                    // remove v from priority queue
                    priorityQueue.remove(v);

                    // update it's values
                    v.setDistance(newDistance);
                    v.setPredecessor(currentPathVertex);

                    // add it back to priority queue
                    priorityQueue.add(v);
                }

                // TODO: Why are we not removing from priority queue, when distance isn't reduced?
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
