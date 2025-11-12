package org.example.LinkedList;

import java.util.*;


public class ArrayToLinkedList {

    // Convert Array to Linked List
    public static ListNode convertArrayToLL(int[] arr) {
        if (arr.length == 0) return null; // handle empty array

        // Step 1: create head node
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        // Step 2: build the linked list
        for (int i = 1; i < arr.length; i++) {
            ListNode newNode = new ListNode(arr[i]);
            current.next = newNode;
            current = current.next; // move pointer forward
        }

        return head; // return the head of the list
    }

    // Print Linked List
    public static void printLinkedList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main Method (for IntelliJ)
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};

        ListNode head = convertArrayToLL(arr);

        System.out.println("Linked List:");
        printLinkedList(head);
    }
}

