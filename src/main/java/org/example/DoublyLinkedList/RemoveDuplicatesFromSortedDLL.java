package org.example.DoublyLinkedList;

public class RemoveDuplicatesFromSortedDLL {

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
        // Example: 1 <-> 1 <-> 2 <-> 3 <-> 3 <-> 4
        Node head = new Node(1);
        Node n2 = new Node(1);
        Node n3 = new Node(2);
        Node n4 = new Node(3);
        Node n5 = new Node(3);
        Node n6 = new Node(4);

        head.next = n2; n2.prev = head;
        n2.next = n3; n3.prev = n2;
        n3.next = n4; n4.prev = n3;
        n4.next = n5; n5.prev = n4;
        n5.next = n6; n6.prev = n5;

        System.out.println("Original DLL:");
        printDLL(head);

        head = removeDuplicates(head);

        System.out.println("\nAfter Removing Duplicates:");
        printDLL(head);
    }

    public static Node removeDuplicates(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node curr = head;

        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                Node duplicate = curr.next;
                curr.next = duplicate.next;
                if (duplicate.next != null) {
                    duplicate.next.prev = curr;
                }
            } else {
                curr = curr.next; // move forward only if no duplicate
            }
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
