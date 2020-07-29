package com.tushar.practice.graphs.graph_ds;

import java.util.ArrayList;
import java.util.List;

public class SimpleVertex {

    private String name;
    private List<SimpleVertex> adjacencyList;

    public SimpleVertex(String name) {
        this.name = name;
        this.adjacencyList = new ArrayList<>();
    }

    public List<SimpleVertex> getAdjacencyList() {
        return adjacencyList;
    }

    public void addNeighbour(SimpleVertex vertex) {
        adjacencyList.add(vertex);
    }

    public void showNeighbours() {
        for (SimpleVertex v : adjacencyList) {
            System.out.println(v);
        }
    }

    public String toString() {
        return name;
//        return "(name: " + name + ", visited: " + visited + ")";
    }


}
