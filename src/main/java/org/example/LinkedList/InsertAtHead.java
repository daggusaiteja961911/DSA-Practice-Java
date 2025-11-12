package org.example.LinkedList;

class InsertAtHead {
    public static ListNode insertAtHead(ListNode head, int newVal) {
        // Step 1: Create a new node
        ListNode newNode = new ListNode(newVal);

        // Step 2: Point new node's next to current head
        newNode.next = head;

        // Step 3: Return new node as new head
        return newNode;
    }

    public static void main(String[] args) {
        // Create initial list: 20 -> 30 -> 40
        ListNode head = new ListNode(20);
        head.next = new ListNode(30);
        head.next.next = new ListNode(40);

        System.out.print("Original List: ");
        printList(head);

        // Insert new node at head
        head = insertAtHead(head, 10);  // new head = 10

        System.out.print("After inserting 10 at head: ");
        printList(head);
    }

    // Helper function to print linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

