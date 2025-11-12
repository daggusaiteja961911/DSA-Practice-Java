package org.example.LinkedList;

public class MergeTwoSortedLists {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static void main(String[] args) {
        // list1 = 1 -> 2 -> 4
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        // list2 = 1 -> 3 -> 4
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode result = mergeTwoLists(list1, list2);
        printList(result); // Output: 1 -> 1 -> 2 -> 3 -> 4 -> 4
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Step 1: Create dummy node
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        // Step 2: Compare nodes one by one
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        // Step 3: Attach remaining nodes
        if (list1 != null) tail.next = list1;
        else tail.next = list2;

        // Step 4: Return merged list (after dummy)
        return dummy.next;
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
}
