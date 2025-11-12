package org.example.LinkedList;

public class SortLinkedList012V1 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        int zero = 0, one = 0, two = 0;

        ListNode temp = head;

        // Step 1: Count 0s, 1s, 2s
        while (temp != null) {
            if (temp.val == 0) zero++;
            else if (temp.val == 1) one++;
            else two++;
            temp = temp.next;
        }

        // Step 2: Rewrite node values
        temp = head;
        while (temp != null) {
            if (zero > 0) {
                temp.val = 0;
                zero--;
            } else if (one > 0) {
                temp.val = 1;
                one--;
            } else {
                temp.val = 2;
                two--;
            }
            temp = temp.next;
        }

        return head;
    }

    public void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + (temp.next != null ? " -> " : ""));
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SortLinkedList012V1 obj = new SortLinkedList012V1();

        ListNode head = new ListNode(1,
                new ListNode(0,
                        new ListNode(2,
                                new ListNode(1,
                                        new ListNode(2,
                                                new ListNode(0))))));

        System.out.print("Original List: ");
        obj.printList(head);

        head = obj.sortList(head);

        System.out.print("Sorted List: ");
        obj.printList(head);
    }
}
