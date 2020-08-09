package com.tushar.dsa.graphs.algorithms.strongly_connected_components;

import com.tushar.dsa.graphs.core.graph_ds_with_edges.Edge;
import com.tushar.dsa.graphs.core.graph_ds_with_edges.Graph;
import com.tushar.dsa.graphs.core.graph_ds_with_edges.Vertex;

import java.util.*;

public class Kosaraju {
    private Set<Vertex> visited = new HashSet<>();

    private Stack<Vertex> stack = new Stack<>();

    private void dfsForTopologicalSort(Vertex current) {
        visited.add(current);

        // First visit all the neighbours recursively
        for (Edge edge :
                current.getAdjacentEdgesList()) {
            Vertex next = edge.getTargetVertex();
            if (!visited.contains(next)) {
                dfsForTopologicalSort(next);
            }
        }

        // Then finally put this vertex to a stack
        // So that the vertex with no outgoing edges(sink),
        // will end up being on the bottom of the stack
        stack.push(current);
    }

    private void dfsForSTC(Vertex current, List<Vertex> connectedComponents) {

        // As we visit a vertex, we need to mark it as visited,
        //and also add it as part of strongly connected components list
        visited.add(current);
        connectedComponents.add(current);

        // First visit all the neighbours recursively
        for (Edge edge :
                current.getAdjacentEdgesList()) {
            Vertex next = edge.getTargetVertex();
            if (!visited.contains(next)) {
                dfsForSTC(next, connectedComponents);
            }
        }
    }

    public void stronglyConnectedComponents(Graph graph, Vertex source) {

        while (visited.size() < graph.getVertices().size()) {

//            System.out.println("next vertex to pick:" + source);

            if (!visited.contains(source)) {
                if (source == null) {
                    dfsForTopologicalSort(graph.getVertices().get(0));
                } else {
                    dfsForTopologicalSort(source);
                }
            }

            int nextIndex = (int) (Math.random() * (graph.getVertices().size()));
            source = graph.getVertices().get(nextIndex);
        }

//        System.out.println("original graph:\n" + graph.toString());

        Graph transposedGraph = graph.transposeGraph();

//        System.out.println("transposed graph:\n" + transposedGraph.toString());

//        System.out.println("stack:\n" + stack);

        visited.clear();


        // make a list of lists, where each list contains vertices of one group of STCs
        List<List<Vertex>> stronglyConnectedComponents = new ArrayList<>();
        while (!stack.isEmpty()) {
            Vertex v = stack.pop();
//            System.out.println("picked: " + v);

            // remember that, after traversing the graph,  in the new graph
            // we have got no references of the original graph's vertices that were stored in the stack,
            // so we will need to find corresponding vertices in the new graph
            Vertex newVertex = transposedGraph.getVertex(v.getName());

            if (visited.contains(newVertex)) {
//                System.out.println("skipped: " + newVertex);
                continue;
            }

            List<Vertex> stc = new ArrayList<>();

//            System.out.println("try finding STC for " + newVertex);
            dfsForSTC(newVertex, stc);
//            System.out.println("found STC for " + newVertex + ",stc:" + stc);


            stronglyConnectedComponents.add(stc);
        }

        for (List<Vertex> stc : stronglyConnectedComponents) {
            System.out.println(stc + "\n");
        }


    }


}


/*
Time complexity:

1st DFS for partial topological sort: O(V+E)
Reverse the graph: O(V+E)
2nd DFS for graph: O(V+E)

 */
