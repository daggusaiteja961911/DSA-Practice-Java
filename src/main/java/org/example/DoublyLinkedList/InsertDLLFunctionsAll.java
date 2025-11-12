package org.example.DoublyLinkedList;

public class InsertDLLFunctionsAll {
    DoublyNode head;

    // 🔹 Insert at Head
    public DoublyNode insertAtHead(DoublyNode head, int val) {
        DoublyNode newNode = new DoublyNode(val);

        if (head == null) {
            return newNode;
        }

        newNode.next = head;
        head.prev = newNode;
        return newNode; // new head
    }

    // 🔹 Insert at Tail
    public DoublyNode insertAtTail(DoublyNode head, int val) {
        DoublyNode newNode = new DoublyNode(val);

        if (head == null) {
            return newNode;
        }

        DoublyNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;
        return head;
    }

    // 🔹 Insert at Given Position (1-based)
    public DoublyNode insertAtPosition(DoublyNode head, int pos, int val) {
        DoublyNode newNode = new DoublyNode(val);

        // Case 1: Insert at head
        if (pos == 1 || head == null) {
            newNode.next = head;
            if (head != null) head.prev = newNode;
            return newNode;
        }

        DoublyNode temp = head;
        for (int i = 1; i < pos - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        // Insert in between
        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null)
            temp.next.prev = newNode;

        temp.next = newNode;

        return head;
    }

    // 🔹 Print List
    public void printList(DoublyNode head) {
        DoublyNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // 🔹 Main Method for Testing
    public static void main(String[] args) {
        InsertDLLFunctionsAll dll = new InsertDLLFunctionsAll();
        DoublyNode head = null;

        // Insert operations
        head = dll.insertAtHead(head, 30);
        head = dll.insertAtHead(head, 20);
        head = dll.insertAtHead(head, 10);
        System.out.print("After insertAtHead: ");
        dll.printList(head);

        head = dll.insertAtTail(head, 40);
        head = dll.insertAtTail(head, 50);
        System.out.print("After insertAtTail: ");
        dll.printList(head);

        head = dll.insertAtPosition(head, 3, 25);
        System.out.print("After insertAtPosition(3, 25): ");
        dll.printList(head);
    }
}
