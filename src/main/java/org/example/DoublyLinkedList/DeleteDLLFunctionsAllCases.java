package org.example.DoublyLinkedList;

public class DeleteDLLFunctionsAllCases {
    DoublyNode head;

    // 🔹 Delete Head Node
    public static DoublyNode deleteHead(DoublyNode head) {
        if (head == null) return null;

        if (head.next == null) return null; // only one node

        head = head.next;
        head.prev = null;
        return head;
    }

    // 🔹 Delete Tail Node
    public static DoublyNode deleteTail(DoublyNode head) {
        if (head == null) return null;
        if (head.next == null) return null;

        DoublyNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.prev.next = null;
        return head;
    }

    // 🔹 Delete Node by Value
    public static DoublyNode deleteByValue(DoublyNode head, int val) {
        if (head == null) return null;

        DoublyNode temp = head;

        // if head node itself holds the value
        if (temp.val == val) {
            head = deleteHead(head);
            return head;
        }

        while (temp != null && temp.val != val) {
            temp = temp.next;
        }

        if (temp == null) return head; // not found

        if (temp.next != null) temp.next.prev = temp.prev;
        if (temp.prev != null) temp.prev.next = temp.next;

        return head;
    }

    // 🔹 Delete Node at Position (1-based)
    public static DoublyNode deleteAtPosition(DoublyNode head, int pos) {
        if (head == null || pos <= 0) return head;

        if (pos == 1) {
            head = deleteHead(head);
            return head;
        }

        DoublyNode temp = head;
        for (int i = 1; temp != null && i < pos; i++) {
            temp = temp.next;
        }

        if (temp == null) return head; // position out of range

        if (temp.next != null) temp.next.prev = temp.prev;
        if (temp.prev != null) temp.prev.next = temp.next;

        return head;
    }

    // 🔹 Print DLL
    public static void printList(DoublyNode head) {
        DoublyNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // 🔹 Main for testing
    public static void main(String[] args) {

        // 🔸 Manually create DLL: 10 <-> 20 <-> 30 <-> 40 <-> 50
        DoublyNode n1 = new DoublyNode(10);
        DoublyNode n2 = new DoublyNode(20);
        DoublyNode n3 = new DoublyNode(30);
        DoublyNode n4 = new DoublyNode(40);
        DoublyNode n5 = new DoublyNode(50);

        n1.next = n2; n2.prev = n1;
        n2.next = n3; n3.prev = n2;
        n3.next = n4; n4.prev = n3;
        n4.next = n5; n5.prev = n4;

        DoublyNode head = n1;
        System.out.print("Original: ");
        printList(head);

        head = deleteHead(head);
        System.out.print("After deleting head: ");
        printList(head);

        head = deleteTail(head);
        System.out.print("After deleting tail: ");
        printList(head);

        head = deleteByValue(head, 30);
        System.out.print("After deleting value 30: ");
        printList(head);

        head = deleteAtPosition(head, 1);
        System.out.print("After deleting at position 1: ");
        printList(head);
    }
}
