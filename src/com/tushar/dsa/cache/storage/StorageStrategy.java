package com.tushar.dsa.cache.storage;

public interface StorageStrategy {
    public void addNode(Node node);
    public Node getNode(int i);
    public int evictEligibleNode();
    public void deleteNode(Node node);
    public int getCapacity();
    public int getSize();
}
