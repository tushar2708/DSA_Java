package com.tushar.dsa.cache.storage;

import java.util.LinkedList;
import java.util.List;

public class LinkedListStorage implements StorageStrategy {
    List<Node> lst;
    int capacity;

    public LinkedListStorage(int capacity) {
        this.capacity = capacity;
        this.lst = new LinkedList<>();
    }

    @Override
    public void addNode(Node node) {        // write lock
        lst.add(node);
    }

    @Override
    public Node getNode(int i) {
        return lst.get(i);                  // read lock
    }

    @Override
    public int evictEligibleNode() {
        if (lst.size() >= capacity){
            // write lock
            int nodeKey = lst.get(0).getData();
            lst.remove(0);
            // unlock
            return nodeKey;
        }
        return Integer.MIN_VALUE;
    }

    @Override
    public void deleteNode(Node node) {     // write lock
        lst.remove(node);   // O(n)
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public int getSize() {
        return lst.size();
    }
}
