package com.tushar.dsa.linked_list.merge_k_sorted_lists;

import com.tushar.dsa.linked_list.common.ListNode;

// https://leetcode.com/problems/merge-k-sorted-lists/
class Solution {

    public ListNode merge2SortedLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode prev = null;

        while (l1 != null && l2 != null) {
            ListNode newNode = new ListNode();
            if (l1.val < l2.val) {
                newNode.val = l1.val;
                l1 = l1.next;
            } else {
                newNode.val = l2.val;
                l2 = l2.next;
            }

            if (head == null) {
                head = newNode;
            } else {
                prev.next = newNode;
            }

            prev = newNode;

        }

        ListNode remainingNode = (l1 != null) ? l1 : l2;

        while (remainingNode != null) {
            ListNode newNode = new ListNode();

            newNode.val = remainingNode.val;

            if (head == null) {
                head = newNode;
            } else {
                prev.next = newNode;
            }

            prev = newNode;
            remainingNode = remainingNode.next;
        }

        return head;
    }

    public ListNode mergeKLists(ListNode[] lists) {

        int numberOfLists = lists.length;
        if (numberOfLists == 0) {
            return null;
        }

        int end = numberOfLists - 1;

        while (end != 0) {

            int i = 0;
            int j = end;

            while (i < j) {
                ListNode l1 = lists[i];
                ListNode l2 = lists[j];

                lists[i] = merge2SortedLists(l1, l2);
                ++i;
                --j;
            }
            end = j;
        }

        return lists[0];
    }
}
