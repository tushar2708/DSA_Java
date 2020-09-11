package com.tushar.dsa.cache.eviction;

import com.tushar.dsa.cache.storage.LinkedListStorage;
import com.tushar.dsa.cache.storage.Node;
import com.tushar.dsa.cache.storage.StorageStrategy;

public class LruEviction implements EvictionStrategy {

    StorageStrategy storageStrategy;

    public LruEviction(int capacity) {
        storageStrategy = new LinkedListStorage(capacity);
    }

    @Override
    public int evictIfNeeded() {
        return storageStrategy.evictEligibleNode();
    }

    @Override
    public Node adjustOrder(Node node) {
        Node newNode = new Node(node.getKey(), node.getData());
        storageStrategy.deleteNode(node);
        storageStrategy.addNode(newNode);
        return newNode;
    }

    @Override
    public void addNode(Node node) {
        storageStrategy.addNode(node);
    }

    @Override
    public void removeNode(Node node) {
        storageStrategy.deleteNode(node);
    }
}
