package com.tushar.dsa.graphs.core.disjoint_sets;

public class DisjointSetNode {
    private DisjointSetNode parent;
    private int rank;

    // Acts as MakeSet operation
    public DisjointSetNode() {
        this.parent = this;
    }

    public DisjointSetNode(DisjointSetNode parent, int rank) {
        this.parent = parent;
        this.rank = rank;
    }

    private DisjointSetNode find(DisjointSetNode x) {
        if (x.parent == x) {
            return x;
        }
        return find(x.parent);
    }

    public DisjointSetNode find() {
        return find(this);
    }

    public void union(DisjointSetNode o) {

        // we will find the parents of both, to ensure merging only happens with the root(representative)
        DisjointSetNode xRoot = find(this);
        DisjointSetNode yRoot = find(o);

        if (xRoot.getRank() > yRoot.getRank()) {
            yRoot.setParent(xRoot); // one with higher rank, xRoot, becomes parent

        } else if (xRoot.getRank() < yRoot.getRank()) {
            xRoot.setParent(yRoot); // one with higher rank, yRoot, becomes parent

        } else {
            xRoot.setParent(yRoot); // both have ranks, anyone can become becomes parent, and it's rank should increase
            yRoot.setRank(yRoot.getRank() + 1);
        }
    }

    public DisjointSetNode getParent() {
        return parent;
    }

    public void setParent(DisjointSetNode parent) {
        this.parent = parent;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
