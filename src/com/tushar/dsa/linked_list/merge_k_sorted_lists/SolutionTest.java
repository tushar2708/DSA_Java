package com.tushar.dsa.linked_list.merge_k_sorted_lists;

import com.tushar.dsa.linked_list.common.ListNode;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void mergeKLists() {
        // [1,4,5],[1,3,4],[2,6]
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode merged = new Solution().mergeKLists(new ListNode[]{l1, l2, l3});
        while (merged != null) {
            System.out.println(merged.val);
            merged = merged.next;
        }
    }
}
