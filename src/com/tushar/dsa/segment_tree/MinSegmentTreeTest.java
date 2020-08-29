package com.tushar.dsa.segment_tree;

import org.junit.Before;
import org.junit.Test;

public class MinSegmentTreeTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void buildTree() {
        MinSegmentTree segmentTree = new MinSegmentTree(new int[]{0, 1, 2, -3});
//        MinSegmentTree segmentTree = new MinSegmentTree(new int[]{0, -3, 1, -3, 1, 2, -3, -1, 1, 5, Integer.MAX_VALUE, Integer.MAX_VALUE, -3, 4});
        segmentTree.buildTree();
        System.out.println(segmentTree.getSegmentTree());
        System.out.println("query 1: " + segmentTree.query(1, 3));

        segmentTree.update(3, 5);
        System.out.println(segmentTree.getSegmentTree());
        System.out.println("query 2: " + segmentTree.query(1, 3));
    }
}
