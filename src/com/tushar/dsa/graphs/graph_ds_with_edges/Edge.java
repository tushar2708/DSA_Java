package com.tushar.dsa.graphs.graph_ds_with_edges;

public class Edge implements Comparable<Edge> {
    private Vertex sourceVertex;
    private Vertex targetVertex;
    private double weight;

    public Edge(Vertex sourceVertex, Vertex targetVertex, double weight) {
        this.sourceVertex = sourceVertex;
        this.targetVertex = targetVertex;
        this.weight = weight;
    }

    public Vertex getSourceVertex() {
        return sourceVertex;
    }

    public void setSourceVertex(Vertex sourceVertex) {
        this.sourceVertex = sourceVertex;
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
                sourceVertex.getName() +
                "=>" + targetVertex.getName() +
                "(" + weight +
                ")}";
    }

    @Override
    public int compareTo(Edge other) {
        return Double.compare(this.weight, other.weight);
    }
}
