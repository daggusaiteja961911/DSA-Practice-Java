package org.example.LinkedList;

import java.util.LinkedList;
import java.util.Queue;

public class MergeKSortedLists_Queue {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static void main(String[] args) {
        // Sample input
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);

        ListNode[] lists = { list1, list2, list3 };

        MergeKSortedLists_Queue obj = new MergeKSortedLists_Queue();
        ListNode result = obj.mergeKLists(lists);

        // Print the merged list
        printList(result); // Expected: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6
    }

    // --------- MAIN LOGIC ----------
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        Queue<ListNode> queue = new LinkedList<>();
        for (ListNode node : lists) {
            if (node != null) queue.add(node);
        }

        // Merge two lists at a time
        while (queue.size() > 1) {
            ListNode l1 = queue.poll();
            ListNode l2 = queue.poll();
            queue.add(merge(l1, l2));
        }

        return queue.isEmpty() ? null : queue.poll();
    }

    // --------- HELPER: Merge Two Sorted Lists ----------
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

    // --------- PRINT FUNCTION ----------
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
}
