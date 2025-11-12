package org.example.LinkedList;

// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class DeleteLLNodes {
    public static ListNode removeElements(ListNode head, int val) {
        // Step 1: Remove all head nodes that match the value
        while (head != null && head.val == val) {
            head = head.next;
        }

        // Step 2: Traverse and remove matching nodes
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next; // skip the node
            } else {
                current = current.next;
            }
        }

        return head;
    }


    public static void main(String[] args) {
        // Create a sample linked list: 1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        int valToRemove = 6;

        ListNode result = removeElements(head, valToRemove);

        // Print the resulting linked list
        System.out.print("Linked List after removal: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}



