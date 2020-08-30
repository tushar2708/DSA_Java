package com.tushar.dsa.linked_list.add_two_large_numbers_as_linked_lists;

import com.tushar.dsa.linked_list.common.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null;
        ListNode prev = null;

        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            sum = sum % 10;

            ListNode newNode = new ListNode(sum);
            if (prev == null) {
                head = newNode;
            } else {
                prev.next = newNode;
            }
            prev = newNode;
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode remaining = (l1 != null) ? l1 : l2;

        while (remaining != null) {
            int sum = remaining.val + carry;
            carry = sum / 10;
            sum = sum % 10;

            ListNode newNode = new ListNode(sum);
            if (prev == null) {
                head = newNode;
            } else {
                prev.next = newNode;
            }

            prev = newNode;
            remaining = remaining.next;
        }

        while (carry > 0) {
            int sum = carry % 10;
            carry = carry / 10;

            prev.next = new ListNode(sum);
        }

        if (head == null) {
            return new ListNode(0);
        }

        return head;
    }
}
