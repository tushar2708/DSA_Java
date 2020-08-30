package com.tushar.dsa.linked_list.clone_list_with_random_pointer;

import java.util.HashMap;
import java.util.Map;

class Solution {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    Map<Node,Node> oldNewMap;

    private Node cloneList(Node node){
        if (node == null){
            return null;
        }

        if (oldNewMap.containsKey(node)){
            return oldNewMap.get(node);
        }

        Node clonedNode = new Node(node.val);
        oldNewMap.put(node, clonedNode);

        clonedNode.next = cloneList(node.next);
        clonedNode.random = cloneList(node.random);

        return clonedNode;
    }

    public Node copyRandomList(Node head) {
        oldNewMap = new HashMap<>();
        return cloneList(head);
    }
}
