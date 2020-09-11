package com.tushar.dsa.cache.eviction;

import com.tushar.dsa.cache.storage.Node;
import com.tushar.dsa.cache.storage.PriorityQueueStorage;
import com.tushar.dsa.cache.storage.StorageStrategy;

public class LfuEviction implements EvictionStrategy {

    StorageStrategy storageStrategy;

    public LfuEviction() {
        storageStrategy = new PriorityQueueStorage();
    }

    @Override
    public int evictIfNeeded() {
        return Integer.MIN_VALUE;
    }

    @Override
    public Node adjustOrder(Node node) {
        return null;
    }

    @Override
    public void addNode(Node node) {

    }

    @Override
    public void removeNode(Node key) {

    }
}
