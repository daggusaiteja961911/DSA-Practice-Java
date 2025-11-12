package org.example.LinkedList;

// Definition for singly-linked list.

public class ReverseEvenLengthGroups {

    public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);

        // Call the function
        ReverseEvenLengthGroups sol = new ReverseEvenLengthGroups();
        ListNode result = sol.reverseEvenLengthGroups(head);

        // Print result
        printList(result);
    }

    public ListNode reverseEvenLengthGroups(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        int groupSize = 1;

        while (head != null) {
            // Step 1: Find actual length of current group
            ListNode temp = head;
            int count = 0;
            while (temp != null && count < groupSize) {
                temp = temp.next;
                count++;
            }

            // Step 2: If group length is even → reverse it
            if (count % 2 == 0) {
                ListNode prev = temp;
                ListNode curr = head;
                for (int i = 0; i < count; i++) {
                    ListNode nextNode = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = nextNode;
                }
                // Connect reversed part
                prevGroupEnd.next = prev;
                prevGroupEnd = head;
                head = temp;
            }
            // Step 3: If odd → skip as is
            else {
                for (int i = 0; i < count; i++) {
                    prevGroupEnd = head;
                    head = head.next;
                }
            }

            // Step 4: Increase group size
            groupSize++;
        }

        return dummy.next;
    }

    // Helper method to print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
}
