package org.example.LinkedList;

public class AddTwoNumbersII {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        // Example Input: l1 = [7 -> 2 -> 4 -> 3], l2 = [5 -> 6 -> 4]
        ListNode l1 = new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3))));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode result = addTwoNumbers(l1, l2);

        // Print the result list
        System.out.print("Result: ");
        printList(result);  // Expected: 7 -> 8 -> 0 -> 7
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Step 1: Reverse both lists
        l1 = reverseList(l1);
        l2 = reverseList(l2);

        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // Step 2: Add both reversed lists (LSB first)
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            int digit = sum % 10;

            // Append new node to the tail
            tail.next = new ListNode(digit);
            tail = tail.next;
        }

        // Step 3: The result is reversed (because we added from least significant side)
        return reverseList(dummy.next);
    }

    // Helper: Reverse a linked list
    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // Helper: Print a linked list
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
}
