package com.tushar.dsa.graphs.graph_ds_with_edges;

import com.tushar.dsa.graphs.graph_ds.SimpleVertex;
import com.tushar.dsa.graphs.traversal.TraversalStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private List<Vertex> vertices;
    private List<Edge> edges;
    private TraversalStrategy traversalStrategy;
    private Map<String, Vertex> vertexMap;

    public Graph() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
        vertexMap = new HashMap<>();
    }

    public void addVertices(Vertex... vxs) {

        for (Vertex v : vxs) {
            vertices.add(v);
            vertexMap.put(v.getName(), v);
        }
    }

    public void addEdge(Vertex source, Vertex target, double weight) {
        Edge edge = new Edge(source, target, weight);
        source.addNeighbour(edge);
        edges.add(edge);
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public Vertex getVertex(String name) {
        return vertexMap.get(name);
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public void setTraversalStrategy(TraversalStrategy traversalStrategy) {
        this.traversalStrategy = traversalStrategy;
    }

    public void traverse(SimpleVertex source) throws Exception {
        traversalStrategy.traverse(source);
    }

    public Graph transposeGraph() {

        Graph transposedGraph = new Graph();

        List<Edge> newEdges = new ArrayList<>();

        for (Vertex v : this.getVertices()) {
            transposedGraph.addVertices(new Vertex(v.getName()));
        }

        for (Edge e : this.getEdges()) {

            Vertex source = transposedGraph.getVertex(e.getSourceVertex().getName());
            Vertex target = transposedGraph.getVertex(e.getTargetVertex().getName());

            Edge newEdge = new Edge(target, source, e.getWeight());
            target.addNeighbour(newEdge);

            newEdges.add(newEdge);
        }

        transposedGraph.setEdges(newEdges);

        return transposedGraph;

//        for (Vertex v : this.getVertices()) {
//
//            List<Edge> adjacentEdges = v.getAdjacentEdgesList();
//            for (int i = 0; i < adjacentEdges.size(); i++) {
//
//                Edge existingEdge = adjacentEdges.get(i);
//                Edge newEdge = new Edge(existingEdge.getTargetVertex(), existingEdge.getStartVertex(),
//                        existingEdge.getWeight());
//
//                // replace with reversed edge
//                adjacentEdges.set(i, newEdge);
//                newEdges.add(newEdge);
//            }
//        }
//        this.setEdges(newEdges);
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Vertices:\n");

        for (Vertex v : this.getVertices()) {
            stringBuilder.append(v.toString()).append("\n");
        }

        stringBuilder.append("Edges:\n");

        for (Edge e : this.getEdges()) {
            stringBuilder.append(e.toString()).append("\n");
        }

        return stringBuilder.toString();
    }
}
