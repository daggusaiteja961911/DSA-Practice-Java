package org.example.LinkedList;

import java.util.Stack;


class RemovesNodesFromLLV2 {
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;

        // Step 1: Traverse and process nodes
        while (curr != null) {
            while (!stack.isEmpty() && stack.peek().val < curr.val) {
                stack.pop();  // remove smaller nodes before current
            }
            stack.push(curr);
            curr = curr.next;
        }

        // Step 2: Build the new linked list from the stack
        ListNode newHead = null;
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            node.next = newHead;
            newHead = node;
        }

        return newHead;
    }

    public static void main(String[] args) {
        RemovesNodesFromLLV2 solution = new RemovesNodesFromLLV2();

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

