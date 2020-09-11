package com.tushar.dsa.trees.zigzag_level_order_traversal;

import com.tushar.dsa.trees.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        int level = 0;
        List<List<Integer>> result = new ArrayList<>();

        Deque<TreeNode> q = new LinkedList<>();
        if (root != null) {
            List<Integer> levelItems = new LinkedList<>();
            q.addLast(root);
            levelItems.add(root.val);
            result.add(levelItems);
        }

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> levelItems = new LinkedList<>();
            for (int i = 0; i < size; i++) {

                if (level % 2 == 0) {
                    TreeNode x = q.removeLast();

                    if (x.right != null) {
                        q.addFirst(x.right);
                        levelItems.add(x.right.val);
                    }

                    if (x.left != null) {
                        q.addFirst(x.left);
                        levelItems.add(x.left.val);
                    }
                } else {

                    TreeNode x = q.removeFirst();

                    if (x.left != null) {
                        q.addLast(x.left);
                        levelItems.add(x.left.val);
                    }

                    if (x.right != null) {
                        q.addLast(x.right);
                        levelItems.add(x.right.val);
                    }
                }
            }
            if (!levelItems.isEmpty()) {
                result.add(levelItems);
            }
            level++;
        }

        return result;
    }
}
