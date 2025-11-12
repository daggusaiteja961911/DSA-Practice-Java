package org.example.LinkedList;

public class AddOneToLinkedList {
    public static ListNode addOne(ListNode head) {
        // Step 1: Reverse the list
        head = reverse(head);

        // Step 2: Add 1 to the number
        ListNode curr = head;
        int carry = 1; // because we need to add 1 initially

        while (curr != null) {
            int sum = curr.val + carry;
            curr.val = sum % 10;
            carry = sum / 10;

            // If no carry left, break early
            if (carry == 0) break;

            // Move to next node, if null we'll handle it
            if (curr.next == null && carry > 0) {
                curr.next = new ListNode(carry);
                carry = 0;
                break;
            }

            curr = curr.next;
        }

        // Step 3: Reverse again to restore original order
        return reverse(head);
    }

    // Helper: reverse a linked list
    private static ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    // Helper: print linked list
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " -> " : ""));
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example: 1 -> 9 -> 9 represents 199
        ListNode head = new ListNode(1);
        head.next = new ListNode(9);
        head.next.next = new ListNode(9);

        System.out.print("Original: ");
        printList(head);

        head = addOne(head);

        System.out.print("After +1 : ");
        printList(head); // Output: 2 -> 0 -> 0
    }
}

