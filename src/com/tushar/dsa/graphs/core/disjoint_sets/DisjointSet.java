package com.tushar.dsa.graphs.core.disjoint_sets;

import com.tushar.dsa.graphs.core.graph_ds_with_edges.Vertex;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    private int nodeCount = 0;
    private int setCount = 0;
    private List<DisjointSetNode> rootNodes;    // representatives

    public DisjointSet(List<Vertex> vertices) {
        rootNodes = new ArrayList<>(vertices.size());
    }

    private void makeSets(List<Vertex> vertices) {
        for (Vertex v :
                vertices) {
            makeSet(v);
        }
    }

    private void makeSet(Vertex vertex) {
        DisjointSetNode node = new DisjointSetNode(null, 0);
        vertex.setDisjointSetNode(node);
        this.rootNodes.add(node);
        this.setCount++;
        this.nodeCount++;
    }

    public DisjointSetNode find(DisjointSetNode node) {
        DisjointSetNode currentNode = node;

        // find root node
        while (currentNode.getParent() != null) {
            currentNode = currentNode.getParent();
        }

        // store root node
        DisjointSetNode rootNode = currentNode;

        // Reset currentNode reference, and do path compression,
        //by setting rootNode as all the intermediate nodes' parent
        currentNode = node;
        while (currentNode != rootNode) {
            DisjointSetNode temp = currentNode.getParent();
            currentNode.setParent(rootNode);
            currentNode = temp; // over-write the reference to the node updated in above line.
        }

        return rootNode;
    }

    public void union(DisjointSetNode node1, DisjointSetNode node2) {

        DisjointSetNode root1 = find(node1);
        DisjointSetNode root2 = find(node2);

        if (root1 == root2) return; // nothing to do, both are already in same set

        // beyond this point, merge is actually needed

        if (root1.getRank() > root2.getRank()) {
            root2.setParent(root1); // one with higher rank, xRoot, becomes parent

        } else if (root1.getRank() < root2.getRank()) {
            root1.setParent(root2); // one with higher rank, yRoot, becomes parent

        } else {
            root1.setParent(root2); // both have ranks, anyone can become becomes parent, and it's rank should increase
            root2.setRank(root2.getRank() + 1);
        }

        this.setCount--;
    }
}
