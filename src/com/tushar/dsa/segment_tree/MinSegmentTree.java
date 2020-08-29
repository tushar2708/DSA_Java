package com.tushar.dsa.segment_tree;

import java.util.Arrays;
import java.util.List;


/*
    Source: https://www.youtube.com/watch?v=nWwt7w2s1So&list=PL2q4fbVm1Ik6v2-emg_JGcC9v2v2YTbvq&index=1
*/
public class MinSegmentTree {

    int[] originalTree;
    List<TreeNode> segmentTree;

    public class TreeNode implements Comparable<TreeNode> {

        int data;

        public TreeNode(int data) {
            this.data = data;
        }

        @Override
        public int compareTo(TreeNode o) {
            return Integer.compare(this.data, o.data);
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "data=" + data +
                    '}';
        }
    }

    public MinSegmentTree(int[] originalTree) {
        this.originalTree = originalTree;

        // segment tree's size is 4 times the sie of the actual array
        this.segmentTree = Arrays.asList(new TreeNode[4 * originalTree.length]);
        for (int i = 0; i < this.segmentTree.size(); i++) {
            this.segmentTree.set(i, new TreeNode(Integer.MAX_VALUE));
        }
    }

    private MinSegmentTree(MinSegmentTree o) {
    }


    public int[] getOriginalTree() {
        return originalTree;
    }

    public List<TreeNode> getSegmentTree() {
        return segmentTree;
    }

    public TreeNode getSegmentTreeNode(int index) {

        if (index >= this.segmentTree.size() || this.originalTree[index] == Integer.MAX_VALUE) {
            return new TreeNode(Integer.MAX_VALUE);
        }

        return segmentTree.get(index);
    }

    private int buildTree(int index, int start, int end) {

//        System.out.println("1. index: " + index + ", start: " + start + ", end: " + end);

        // base case, for leaf node
        if (start == end) {
//            System.out.println("2. index: " + index + "->[" + this.originalTree[start] + "], start: " + start + ",end: " + end);
            this.segmentTree.set(index, new TreeNode(this.originalTree[start]));
            return this.originalTree[start];
        }

        int mid = (start + end) / 2;

        int indexL = (2 * index);
        int indexR = (2 * index) + 1;

        int minL = buildTree(indexL, start, mid);
        int minR = buildTree(indexR, mid + 1, end);

        // take the minimum value, while coming back from recursion
        int min = Integer.min(minL, minR);
//        System.out.println("2. index: " + index + "->[" + min + "], start: " + start + ",end: " + end);

        this.segmentTree.get(index).setData(min);

        return min;
    }

    public void buildTree() {

        buildTree(1, 1, this.originalTree.length - 1);
    }

    private TreeNode query(int segIndex, int segStart, int segEnd, int qStart, int qEnd) {

        // if segment lies completely outside of the query
        if (qStart > segEnd || qEnd < segStart) {
//            System.out.println("outside. index: " + segIndex + "->[" +Integer.MAX_VALUE + "], start: " + segStart + ",end: " + segEnd);
            return new TreeNode(Integer.MAX_VALUE);
        }

        // if segment lies completely inside the query
        if (qStart <= segStart && qEnd >= segEnd) {
//            System.out.println("inside. index: " + segIndex + "->[" + segmentTree.get(segIndex) + "], start: " + segStart + ",end: " + segEnd);
            return segmentTree.get(segIndex);
        }

        // it's partial overlap
        int mid = (segStart + segEnd) / 2;
        TreeNode l = query(2 * segIndex, segStart, mid, qStart, qEnd);
        TreeNode r = query(2 * segIndex + 1, mid + 1, segEnd, qStart, qEnd);

        if (l.compareTo(r) <= 0) {
            return l;
        }
        return r;
    }

    public TreeNode query(int qStart, int qEnd) {
        return query(1, 1, this.originalTree.length - 1, qStart, qEnd);
    }

    private void update(int segIndex, int segStart, int segEnd, int uIndex) {

//        System.out.println("1. segIndex: " + segIndex + ", originalTree->[" + originalTree[segStart] + "], segStart: " + segStart + ", segEnd: " + segEnd);

        if (segStart == segEnd) {
            segmentTree.get(segIndex).setData(originalTree[segStart]);
            return;
        }

        int mid = (segStart + segEnd) / 2;
        int indexL = (2 * segIndex);
        int indexR = (2 * segIndex) + 1;

        if (uIndex <= mid) {
            update(indexL, segStart, mid, uIndex);
        } else {
            update(indexR, mid + 1, segEnd, uIndex);
        }

        TreeNode l = segmentTree.get(indexL);
        TreeNode r = segmentTree.get(indexR);
        TreeNode min;

        if (l.compareTo(r) <= 0) {
            min = l;
        } else {
            min = r;
        }

        segmentTree.get(segIndex).setData(min.data);
    }

    public void update(int uIndex, int uValue) {
        this.originalTree[uIndex] = uValue;
        update(1, 1, originalTree.length - 1, uIndex);
    }
}
