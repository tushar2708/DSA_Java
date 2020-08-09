package com.tushar.dsa.graphs.algorithms.min_cut_and_max_flow;

import com.tushar.dsa.graphs.core.flow_graph_ds.FlowEdge;
import com.tushar.dsa.graphs.core.flow_graph_ds.FlowGraph;
import com.tushar.dsa.graphs.core.flow_graph_ds.FlowVertex;

import java.util.*;


public class FordFulkersonMaxFlowAlgo {

    Queue<FlowVertex> queue = new ArrayDeque<>();


    public double findMaxFlow(FlowGraph graph, FlowVertex source, FlowVertex target) {

        double maxFlow = 0;

        while (true) {

            List<FlowVertex> path = null;

            try {
                path = bfsToFindNextPath(source, target);
                System.out.println("S->T path: " + path);
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }

            FlowVertex prev = null;
            FlowVertex current;

            double minResidualFlow = Integer.MAX_VALUE;
            List<FlowEdge> pathWithEdges = new ArrayList<>();

            for (FlowVertex v : path) {
                current = v;
                if (prev != null) {
                    FlowEdge e = prev.getEdgeForTarget(current);
                    if (e.getResidualCapacity() < minResidualFlow) {
                        minResidualFlow = e.getResidualCapacity();
                    }
                    pathWithEdges.add(e);
                }
                prev = current;
            }

            if (minResidualFlow == 0) {
                break;
            }

            maxFlow += minResidualFlow;

            for (FlowEdge e : pathWithEdges) {
                // add minimum possible flow to all edges of the path
                e.setFlow(e.getFlow() + minResidualFlow);

                // add minimum possible flow to all reverse residual capacities edges of the path
                e.setBackResidualCapacity(e.getBackResidualCapacity() + minResidualFlow);

                // reduce minimum possible flow from all edges of the path
                e.setResidualCapacity(e.getResidualCapacity() - minResidualFlow);
            }
        }

        return maxFlow;
    }

    private List<FlowVertex> bfsToFindNextPath(FlowVertex source, FlowVertex target) throws Exception {

        Map<String, FlowVertex> parentMap = new HashMap<>();
        Set<FlowVertex> visited = new HashSet<>();

        // Start a fresh BFS
        queue.add(source);

        while (!queue.isEmpty()) {

            FlowVertex current = queue.remove();
            visited.add(current);

            for (FlowEdge edge : current.getAdjacentEdgesList()) {

                if (edge.getResidualCapacity() == 0) continue;

                FlowVertex next = edge.getTargetVertex();
                if (!visited.contains(next)) {
                    queue.add(next);
                    parentMap.put(next.getName(), current);
                }
            }
        }

        System.out.println("parentMap: " + parentMap);

        List<FlowVertex> sourceToTargetPath = new ArrayList<>();
        FlowVertex temp = target;

        while (temp != null) {
            sourceToTargetPath.add(0, temp);    // keep adding nodes in the beginning. Last one will be source
            temp = parentMap.get(temp.getName());
        }

        System.out.println("sourceToTargetPath: " + sourceToTargetPath);

        if (sourceToTargetPath.get(0) != source || sourceToTargetPath.get(sourceToTargetPath.size() - 1) != target) {
            throw new Exception("no S->T path exists");
        }

        return sourceToTargetPath;
    }

}
