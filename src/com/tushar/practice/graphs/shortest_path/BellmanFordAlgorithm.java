package com.tushar.practice.graphs.shortest_path;

import com.tushar.practice.graphs.graph_ds_with_edges.Edge;
import com.tushar.practice.graphs.graph_ds_with_edges.Vertex;

import java.util.ArrayList;
import java.util.List;

public class BellmanFordAlgorithm {

    private List<Edge> edgeList;
    private List<Vertex> vertexList;

    public BellmanFordAlgorithm(List<Edge> edgeList, List<Vertex> vertexList) {
        this.edgeList = edgeList;
        this.vertexList = vertexList;
    }

    public void computePaths(Vertex source) throws Exception {

        source.setDistance(0);

        // Relax all the edges v-1 times
        for (int i = 0; i < this.vertexList.size() - 1; i++) {

            for (Edge edge :
                    edgeList) {

                Vertex u = edge.getStartVertex();
                Vertex v = edge.getTargetVertex();

                if (u.getDistance() == Double.MAX_VALUE) {
                    continue;
                }

                double newDistance = u.getDistance() + edge.getWeight();
                if (newDistance < v.getDistance()) {
                    v.setDistance(newDistance);
                    v.setPredecessor(u);
                }
            }
        }

        // Attempt to relax all the edges one more time,
        //to see if negative edge cycle(s) exist
        for (Edge edge :
                edgeList) {

            Vertex u = edge.getStartVertex();
            Vertex v = edge.getTargetVertex();

            if (u.getDistance() == Double.MAX_VALUE) {
                continue;
            }

            double newDistance = u.getDistance() + edge.getWeight();
            if (newDistance < v.getDistance()) {
                throw new Exception("negative edge cycle exists");
            }
        }
    }

    public List<Vertex> getShortestPathTo(Vertex targetPathVertex) throws Exception {
        List<Vertex> shortestPathToTarget = new ArrayList<>();

        if (targetPathVertex.getDistance() == Double.MAX_VALUE) {
            throw new Exception("there is no path from source to target vertex");
        }

        for (Vertex pathVertex = targetPathVertex;
             pathVertex != null;
             pathVertex = pathVertex.getPredecessor()) {

            shortestPathToTarget.add(0, pathVertex);
        }

        return shortestPathToTarget;
    }

}
