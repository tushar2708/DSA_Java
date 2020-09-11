package com.tushar.dsa.cache.storage;

import java.util.PriorityQueue;

public class PriorityQueueStorage implements StorageStrategy {
    PriorityQueue<Node> lst;

    public PriorityQueueStorage() {
        this.lst = new PriorityQueue<>();
    }


    @Override
    public void addNode(Node node) {
        lst.add(node);
    }

    @Override
    public Node getNode(int i) {
        return null;    // TODO: See if this method is needed?
    }

    @Override
    public int evictEligibleNode() {
        return 0;
    }

    @Override
    public void deleteNode(Node node) {
        lst.remove(node);
    }

    @Override
    public int getCapacity() {
        return 0;
    }

    @Override
    public int getSize() {
        return 0;
    }
}
