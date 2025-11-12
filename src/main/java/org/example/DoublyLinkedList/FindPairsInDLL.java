package org.example.DoublyLinkedList;

import java.util.*;

public class FindPairsInDLL {

    // Definition of Doubly Linked List Node
    static class Node {
        int val;
        Node next;
        Node prev;
        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // Create DLL: 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6
        Node head = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        head.next = n2; n2.prev = head;
        n2.next = n3; n3.prev = n2;
        n3.next = n4; n4.prev = n3;
        n4.next = n5; n5.prev = n4;
        n5.next = n6; n6.prev = n5;

        int target = 7;

        System.out.println("Doubly Linked List:");
        printDLL(head);

        System.out.println("\nPairs with sum = " + target + ":");
        findPairsWithSum(head, target);
    }

    public static void findPairsWithSum(Node head, int target) {
        if (head == null) return;

        Node left = head;
        Node right = head;

        // Move right to the end (tail)
        while (right.next != null) {
            right = right.next;
        }

        boolean found = false;

        while (left != null && right != null && left != right && right.next != left) {
            int sum = left.val + right.val;

            if (sum == target) {
                System.out.println("(" + left.val + ", " + right.val + ")");
                found = true;
                left = left.next;
                right = right.prev;
            } else if (sum < target) {
                left = left.next;
            } else {
                right = right.prev;
            }
        }

        if (!found) {
            System.out.println("No pairs found.");
        }
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
