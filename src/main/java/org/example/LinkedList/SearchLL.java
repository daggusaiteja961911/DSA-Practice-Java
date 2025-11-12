package org.example.LinkedList;

public class SearchLL {
    public static boolean search(ListNode head, int target) {
        ListNode current = head;

        // Traverse the list
        while (current != null) {
            if (current.val == target) {
                return true; // found
            }
            current = current.next; // move to next node
        }

        return false; // not found
    }

    // Example
    public static void main(String[] args) {
        // Create Linked List: 1 → 3 → 5 → 7
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(7);

        int target = 10;
        System.out.println(search(head, target)); // ✅ true
    }
}
