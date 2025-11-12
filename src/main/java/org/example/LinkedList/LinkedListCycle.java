package org.example.LinkedList;

public class LinkedListCycle {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // Example 1: Cycle exists
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);

        // Create a cycle: -4 -> 2
        head.next.next.next.next = head.next;

        System.out.println("Has cycle? " + hasCycle(head)); // true

        // Example 2: No cycle
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        System.out.println("Has cycle? " + hasCycle(a)); // false
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true; // Cycle detected
            }
        }
        return false; // No cycle
    }
}
