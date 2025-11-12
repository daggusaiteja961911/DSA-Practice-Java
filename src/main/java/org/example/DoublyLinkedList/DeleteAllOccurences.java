package org.example.DoublyLinkedList;

public class DeleteAllOccurences {

    // Definition for Doubly Linked List Node
    static class Node {
        int val;
        Node next;
        Node prev;
        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // Example: DLL = 1 <-> 2 <-> 3 <-> 2 <-> 4 <-> 2 <-> 5
        Node head = new Node(2);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(2);
        Node n5 = new Node(4);
        Node n6 = new Node(2);
        Node n7 = new Node(5);

        head.next = n2; n2.prev = head;
        n2.next = n3; n3.prev = n2;
        n3.next = n4; n4.prev = n3;
        n4.next = n5; n5.prev = n4;
        n5.next = n6; n6.prev = n5;
        n6.next = n7; n7.prev = n6;

        System.out.println("Original DLL:");
        printDLL(head);

        int key = 2;
        head = deleteAllOccurrences(head, key);

        System.out.println("\nAfter Deleting All Occurrences of " + key + ":");
        printDLL(head);
    }

    public static Node deleteAllOccurrences(Node head, int key) {
        if (head == null) return null;

        Node curr = head;

        while (curr != null) {
            if (curr.val == key) {
                // If current node is head
                if (curr == head) {
                    head = curr.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else {
                    // Adjust previous node's next
                    curr.prev.next = curr.next;
                    if (curr.next != null) {
                        curr.next.prev = curr.prev;
                    }
                }
            }
            curr = curr.next;
        }

        return head;
    }

    public static void printDLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null) System.out.print(" <-> ");
            temp = temp.next;
        }
        System.out.println();
    }
}
