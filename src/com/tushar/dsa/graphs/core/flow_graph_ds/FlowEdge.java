package com.tushar.dsa.graphs.core.flow_graph_ds;

public class FlowEdge implements Comparable<FlowEdge> {
    private FlowVertex sourceVertex;
    private FlowVertex targetVertex;
    private double weight;
    private double capacity;
    private double flow;
    private double residualCapacity;
    private double backResidualCapacity;

    public FlowEdge(FlowVertex sourceVertex, FlowVertex targetVertex, double weight, double capacity, double initialFlow) {
        this.sourceVertex = sourceVertex;
        this.targetVertex = targetVertex;
        this.weight = weight;
        this.capacity = capacity;
        this.flow = initialFlow;
        this.residualCapacity = capacity - initialFlow;
    }

    public FlowVertex getSourceVertex() {
        return sourceVertex;
    }

    public void setSourceVertex(FlowVertex sourceVertex) {
        this.sourceVertex = sourceVertex;
    }

    public FlowVertex getTargetVertex() {
        return targetVertex;
    }

    public void setTargetVertex(FlowVertex targetVertex) {
        this.targetVertex = targetVertex;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getFlow() {
        return flow;
    }

    public void setFlow(double flow) {
        this.flow = flow;
    }

    public double getResidualCapacity() {
        return residualCapacity;
    }

    public void setResidualCapacity(double residualCapacity) {
        this.residualCapacity = residualCapacity;
    }

    public double getBackResidualCapacity() {
        return backResidualCapacity;
    }

    public void setBackResidualCapacity(double backResidualCapacity) {
        this.backResidualCapacity = backResidualCapacity;
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
    public int compareTo(FlowEdge other) {
        return Double.compare(this.weight, other.weight);
    }
}
