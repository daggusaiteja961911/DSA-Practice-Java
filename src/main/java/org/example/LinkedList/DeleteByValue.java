package org.example.LinkedList;

class DeleteByValue {
    public static ListNode deleteByValue(ListNode head, int value) {
        // Case 1: Empty list
        if (head == null) return null;

        // Case 2: If the node to delete is head
        if (head.val == value) {
            return head.next;
        }

        // Case 3: Traverse to find node whose next has target value
        ListNode temp = head;
        while (temp.next != null && temp.next.val != value) {
            temp = temp.next;
        }

        // If value not found
        if (temp.next == null) {
            System.out.println("Value not found in the list!");
            return head;
        }

        // Case 4: Delete the node
        temp.next = temp.next.next;

        return head;
    }

    public static void main(String[] args) {
        // Create list: 10 -> 20 -> 30 -> 40 -> 50
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        head.next.next.next.next = new ListNode(50);

        System.out.print("Original List: ");
        printList(head);


        // Delete node with value 30
        head = deleteByValue(head, 30);

        System.out.print("After deleting 30: ");
        printList(head);

        // Try deleting a value that doesn't exist
        head = deleteByValue(head, 100);
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

