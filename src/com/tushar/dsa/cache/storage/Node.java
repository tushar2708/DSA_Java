package com.tushar.dsa.cache.storage;

public class Node {

    int key;
    int data;

    public Node(int key, int data) {
        this.key = key;
        this.data = data;
    }

    public int getKey() {
        return key;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

}
