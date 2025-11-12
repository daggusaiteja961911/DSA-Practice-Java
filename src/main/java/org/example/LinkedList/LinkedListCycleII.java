package org.example.LinkedList;

public class LinkedListCycleII {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // Create linked list: 3 -> 2 -> 0 -> -4
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);

        // Create cycle: -4 -> 2
        head.next.next.next.next = head.next;

        ListNode startNode = detectCycle(head);
        if (startNode != null)
            System.out.println("Cycle starts at node with value: " + startNode.val);
        else
            System.out.println("No cycle detected");
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect if cycle exists
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Step 2: Find the start of cycle
                slow = head; // reset slow to head
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; // both meet at start of cycle
            }
        }

        return null; // no cycle
    }
}
