package com.tushar.dsa.graphs.core.flow_graph_ds;

import com.tushar.dsa.graphs.core.disjoint_sets.DisjointSetNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlowVertex implements Comparable<FlowVertex> {
    private String name;
    private List<FlowEdge> adjacentEdgesList;
    private Map<FlowVertex, FlowEdge> adjacentEdgesMap;
    private FlowVertex predecessor;
    private double distance = Double.MAX_VALUE;
    private boolean visited;
    private DisjointSetNode disjointSetNode;

    public FlowVertex(String name) {
        this.name = name;
        this.adjacentEdgesList = new ArrayList<>();
        this.adjacentEdgesMap = new HashMap<>();
        this.disjointSetNode = new DisjointSetNode();
    }

    public void addNeighbourEdge(FlowEdge flowEdge) {
        this.adjacentEdgesList.add(flowEdge);
        this.adjacentEdgesMap.put(flowEdge.getTargetVertex(), flowEdge);
    }


    public void addNeighbourVertex(FlowVertex target, double weight, double capacity, double initialFlow) {
        FlowEdge flowEdge = new FlowEdge(this, target, weight, capacity, initialFlow);
        this.adjacentEdgesList.add(flowEdge);
        this.adjacentEdgesMap.put(target, flowEdge);
    }

    public FlowEdge getEdgeForTarget(FlowVertex target) {
        return adjacentEdgesMap.get(target);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FlowEdge> getAdjacentEdgesList() {
        return adjacentEdgesList;
    }

    public void setAdjacentEdgesList(List<FlowEdge> adjacentEdgesList) {
        this.adjacentEdgesList = adjacentEdgesList;
    }

    public FlowVertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(FlowVertex predecessor) {
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
    public int compareTo(FlowVertex other) {
        return Double.compare(this.distance, other.distance);
    }

}

