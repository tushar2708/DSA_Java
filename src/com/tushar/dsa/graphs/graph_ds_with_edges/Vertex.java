package com.tushar.dsa.graphs.graph_ds_with_edges;

import com.tushar.dsa.graphs.disjoint_sets.DisjointSetNode;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {
    private String name;
    private List<Edge> adjacentEdgesList;
    private Vertex predecessor;
    private double distance = Double.MAX_VALUE;
    private boolean visited;
    private DisjointSetNode disjointSetNode;

    public Vertex(String name) {
        this.name = name;
        this.adjacentEdgesList = new ArrayList<>();
        this.disjointSetNode = new DisjointSetNode();
    }

    public void addNeighbour(Edge edge) {
        this.adjacentEdgesList.add(edge);
    }

    public void addNeighbourVertex(Vertex target, double weight) {
        Edge edge = new Edge(this, target, weight);
        this.adjacentEdgesList.add(edge);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Edge> getAdjacentEdgesList() {
        return adjacentEdgesList;
    }

    public void setAdjacentEdgesList(List<Edge> adjacentEdgesList) {
        this.adjacentEdgesList = adjacentEdgesList;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public DisjointSetNode getDisjointSetNode() {
        return disjointSetNode;
    }

    public void setDisjointSetNode(DisjointSetNode disjointSetNode) {
        this.disjointSetNode = disjointSetNode;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "name='" + name + '\'' +
//                ", minDistance=" + distance +
                '}';
    }

    @Override
    public int compareTo(Vertex other) {
        return Double.compare(this.distance, other.distance);
    }

}

