package com.tushar.dsa.graphs.questions.clone_graph;

/*
// Definition for a Node.

*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node newNode(int val) {
        return new Node(val);
    }

    Map<Node, Node> nodeMap; // this same map will be used as visited tracker too

    public Solution() {
        nodeMap = new HashMap<>();
    }

    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }

        Node clonedNode = new Node(node.val);
        nodeMap.put(node, clonedNode);

        for (Node nghb : node.neighbors) {
            if (nghb == null) {
                continue;
            }

            if (nodeMap.containsKey(nghb)) {
                clonedNode.neighbors.add(nodeMap.get(nghb));
                continue;
            }

            Node clonedNeighbour = cloneGraph(nghb);
            if (clonedNeighbour != null) {
                clonedNode.neighbors.add(clonedNeighbour);
            }
        }
        return clonedNode;
    }
}
