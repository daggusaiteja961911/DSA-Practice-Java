package org.example.LinkedList;


class InsertAtKthPosition {
    public static ListNode insertAtKthPosition(ListNode head, int newVal, int k) {
        ListNode newNode = new ListNode(newVal);

        // Case 1: Insert at head (k == 1)
        if (k == 1) {
            newNode.next = head;
            return newNode;
        }

        // Case 2: Traverse to (k-1)th node
        ListNode temp = head;
        for (int i = 1; i < k - 1 && temp != null; i++) {
            temp = temp.next;
        }

        // If position is out of bounds
        if (temp == null) {
            System.out.println("Position out of range!");
            return head;
        }

        // Case 3: Insert new node between temp and temp.next
        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }

    public static void main(String[] args) {
        // Create list: 10 -> 20 -> 30 -> 40
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);

        System.out.print("Original List: ");
        printList(head);

        // Insert 25 at position 3 (1-based index)
        head = insertAtKthPosition(head, 25, 3);

        System.out.print("After inserting 25 at position 3: ");
        printList(head);
    }

    // Helper to print linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

