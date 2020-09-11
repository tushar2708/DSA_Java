package com.tushar.dsa.cache;

import com.tushar.dsa.cache.eviction.EvictionStrategy;
import com.tushar.dsa.cache.eviction.LruEviction;
import com.tushar.dsa.cache.storage.Node;

import java.util.HashMap;
import java.util.Map;

public class Cache {
    Map<Integer, Node> map;

    int capacity;
    EvictionStrategy evictionStrategy;

    public Cache(int capacity) {
        map = new HashMap<>();
        evictionStrategy = new LruEviction(capacity);
    }

    public void setEvictionStrategy(EvictionStrategy strategy) {
        evictionStrategy = strategy;
    }

    public boolean containsKey(int key) {   // wouldn't be counted as access
        return map.containsKey(key);
    }

    public synchronized int get(int key) {
        /*
        if exists:
        return value and adjust order
        else: throw exception
         */

        if (map.containsKey(key)) {

            Node node = map.get(key);
            node = evictionStrategy.adjustOrder(node);
            map.put(key, node);
            return node.getData();
        } else {
            return Integer.MIN_VALUE;
        }

    }

    public void put(int key, int val) {

        int oldKey = evictionStrategy.evictIfNeeded();
        if (oldKey != Integer.MIN_VALUE) {
            map.remove(oldKey);
        }

        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.setData(val);
            node = evictionStrategy.adjustOrder(node);
            map.put(key, node);
            return;
        } else {
            Node newNode = new Node(key, val);
            map.put(key, newNode);
            evictionStrategy.addNode(newNode);
        }
    }

    public boolean remove(int key) {
        if (map.containsKey(key)) {
            evictionStrategy.removeNode(map.get(key));
            map.remove(key);
            return true;
        }
        return false;
    }
}
