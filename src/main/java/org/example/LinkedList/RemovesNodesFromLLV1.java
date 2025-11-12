package org.example.LinkedList;

class RemovesNodesFromLLV1 {
    public ListNode removeNodes(ListNode head) {
        // Step 1: Reverse the linked list
        ListNode rev = reverse(head);

        // Step 2: Keep only nodes >= max value seen so far
        int max = rev.val;
        ListNode curr = rev;
        while (curr != null && curr.next != null) {
            if (curr.next.val < max) {
                curr.next = curr.next.next; // delete smaller node
            } else {
                curr = curr.next;
                max = curr.val;
            }
        }

        // Step 3: Reverse again to restore original order
        return reverse(rev);
    }

    // Helper: Reverse Linked List
    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        RemovesNodesFromLLV1 solution = new RemovesNodesFromLLV1();

        // Example: Creating a linked list 5 -> 2 -> 13 -> 3 -> 8
        ListNode head = new ListNode(5);
        head.next = new ListNode(2);
        head.next.next = new ListNode(13);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(8);

        // Removing nodes
        ListNode result = solution.removeNodes(head);

        // Printing the resulting linked list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}

