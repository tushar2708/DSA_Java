package com.tushar.practice.graphs.common;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String name;
    private boolean visited;
    private List<Vertex> adjacencyList;

    public Vertex(String name) {
        this.name = name;
        this.adjacencyList = new ArrayList<>();
    }

    public boolean getVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Vertex> getAdjacencyList() {
        return adjacencyList;
    }

    public void addNeighbour(Vertex vertex) {
        adjacencyList.add(vertex);
    }

    public void showNeighbours() {
        for (Vertex v : adjacencyList) {
            System.out.println(v);
        }
    }

    public String toString() {
        return name;
    }


}
