package org.example.LinkedList;

public class SortLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static void main(String[] args) {
        // Example input: 4 -> 2 -> 1 -> 3
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        ListNode sorted = sortList(head);
        printList(sorted); // Expected: 1 -> 2 -> 3 -> 4
    }

    // --------- MAIN SORT METHOD ----------
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // Step 1: Split into two halves
        ListNode mid = getMiddle(head);
        ListNode right = mid.next;
        mid.next = null;

        // Step 2: Sort each half
        ListNode leftSorted = sortList(head);
        ListNode rightSorted = sortList(right);

        // Step 3: Merge the two halves
        return merge(leftSorted, rightSorted);
    }

    // --------- FIND MIDDLE NODE ----------
    private static ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // --------- MERGE TWO SORTED LISTS ----------
    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

    // --------- PRINT FUNCTION ----------
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
}
