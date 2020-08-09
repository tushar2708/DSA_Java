package com.tushar.dsa.graphs.core.flow_graph_ds;

import com.tushar.dsa.graphs.core.simple_graph_ds.SimpleVertex;
import com.tushar.dsa.graphs.algorithms.traversal.TraversalStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlowGraph {

    private List<FlowVertex> vertices;
    private List<FlowEdge> flowEdges;
    private TraversalStrategy traversalStrategy;
    private Map<String, FlowVertex> vertexMap;

    public FlowGraph() {
        vertices = new ArrayList<>();
        flowEdges = new ArrayList<>();
        vertexMap = new HashMap<>();
    }

    public void addVertices(FlowVertex... vxs) {

        for (FlowVertex v : vxs) {
            vertices.add(v);
            vertexMap.put(v.getName(), v);
        }
    }

    public void addEdge(FlowVertex source, FlowVertex target, double weight, double capacity, double initialFlow) {
        FlowEdge flowEdge = new FlowEdge(source, target, weight, capacity, initialFlow);
        source.addNeighbourEdge(flowEdge);
        flowEdges.add(flowEdge);
    }

    public List<FlowVertex> getVertices() {
        return vertices;
    }

    public FlowVertex getVertex(String name) {
        return vertexMap.get(name);
    }

    public List<FlowEdge> getFlowEdges() {
        return flowEdges;
    }

    public void setFlowEdges(List<FlowEdge> flowEdges) {
        this.flowEdges = flowEdges;
    }

    public void setTraversalStrategy(TraversalStrategy traversalStrategy) {
        this.traversalStrategy = traversalStrategy;
    }

    public void traverse(SimpleVertex source) throws Exception {
        traversalStrategy.traverse(source);
    }

    public FlowGraph transposeGraph() {

        FlowGraph transposedFlowGraph = new FlowGraph();

        List<FlowEdge> newFlowEdges = new ArrayList<>();

        for (FlowVertex v : this.getVertices()) {
            transposedFlowGraph.addVertices(new FlowVertex(v.getName()));
        }

        for (FlowEdge e : this.getFlowEdges()) {

            FlowVertex source = transposedFlowGraph.getVertex(e.getSourceVertex().getName());
            FlowVertex target = transposedFlowGraph.getVertex(e.getTargetVertex().getName());

            FlowEdge newFlowEdge = new FlowEdge(target, source, e.getWeight(), e.getCapacity(), e.getFlow());
            target.addNeighbourEdge(newFlowEdge);

            newFlowEdges.add(newFlowEdge);
        }

        transposedFlowGraph.setFlowEdges(newFlowEdges);

        return transposedFlowGraph;

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

        for (FlowVertex v : this.getVertices()) {
            stringBuilder.append(v.toString()).append("\n");
        }

        stringBuilder.append("Edges:\n");

        for (FlowEdge e : this.getFlowEdges()) {
            stringBuilder.append(e.toString()).append("\n");
        }

        return stringBuilder.toString();
    }
}
