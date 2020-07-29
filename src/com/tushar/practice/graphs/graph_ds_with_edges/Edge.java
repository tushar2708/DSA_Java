package com.tushar.practice.graphs.graph_ds_with_edges;

public class Edge implements Comparable<Edge> {
    private Vertex startVertex;
    private Vertex targetVertex;
    private double weight;

    public Edge(Vertex startVertex, Vertex targetVertex, double weight) {
        this.startVertex = startVertex;
        this.targetVertex = targetVertex;
        this.weight = weight;
    }

    public Vertex getStartVertex() {
        return startVertex;
    }

    public void setStartVertex(Vertex startVertex) {
        this.startVertex = startVertex;
    }

    public Vertex getTargetVertex() {
        return targetVertex;
    }

    public void setTargetVertex(Vertex targetVertex) {
        this.targetVertex = targetVertex;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                startVertex.getName() +
                "=>" + targetVertex.getName() +
                "(" + weight +
                ")}";
    }

    @Override
    public int compareTo(Edge e) {
        return Double.compare(this.weight, e.weight);
    }
}
