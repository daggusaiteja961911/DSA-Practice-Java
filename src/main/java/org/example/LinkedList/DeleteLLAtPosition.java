package org.example.LinkedList;

class DeleteLLAtPosition {
    public static ListNode deleteAtPosition(ListNode head, int position) {
        // If list is empty
        if (head == null) return null;

        // If deleting the head node (position = 0)
        if (position == 0) {
            return head.next;
        }

        // Traverse to node before the position
        ListNode current = head;
        for (int i = 0; current != null && i < position - 1; i++) {
            current = current.next;
        }

        // If position is out of range
        if (current == null || current.next == null) {
            return head;
        }

        // Skip the node at 'position'
        current.next = current.next.next;
        return head;
    }

    public static void main(String[] args) {
        // Create sample linked list: 10 -> 20 -> 30 -> 40 -> 50
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        head.next.next.next.next = new ListNode(50);

        System.out.print("Original List: ");
        printList(head);

        int pos = 2; // delete node at index 2 (0-based index -> removes 30)

        head = deleteAtPosition(head, pos);

        System.out.print("After Deletion at position " + pos + ": ");
        printList(head);
    }

    // Helper method to print linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

