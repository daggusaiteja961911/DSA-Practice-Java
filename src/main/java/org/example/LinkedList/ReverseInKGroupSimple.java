package org.example.LinkedList;

public class ReverseInKGroupSimple {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // Create Linked List: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;
        System.out.println("Original List:");
        printList(head);

        head = reverseKGroup(head, k);

        System.out.println("\nReversed in groups of " + k + ":");
        printList(head);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1)
            return head;

        // Step 1: Count total nodes
        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        // Step 2: Create dummy node to make linking easier
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode tail = dummy;
        ListNode temp;

        // Step 3: Repeat reversal for every k nodes
        while (count >= k) {
            curr = prev.next;
            tail = curr;

            // Reverse k nodes
            for (int i = 1; i < k; i++) {
                temp = curr.next;
                curr.next = temp.next;
                temp.next = prev.next;
                prev.next = temp;
            }

            // Move prev to tail (end of this group)
            prev = tail;
            count -= k;
        }

        return dummy.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
}
