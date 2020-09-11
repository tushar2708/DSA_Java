package com.tushar.dsa.cache.eviction;

import com.tushar.dsa.cache.storage.Node;

public interface EvictionStrategy {
    public int evictIfNeeded();
    public Node adjustOrder(Node node);
    public void addNode(Node node);
    public void removeNode(Node key);
}
