package org.example.LinkedList;

public class SortLinkedList012V2 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // Dummy heads for 0s, 1s, and 2s
        ListNode zeroHead = new ListNode(-1);
        ListNode oneHead = new ListNode(-1);
        ListNode twoHead = new ListNode(-1);

        // Tails for each list
        ListNode zero = zeroHead, one = oneHead, two = twoHead;

        // Step 1: Partition nodes into 3 lists
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == 0) {
                zero.next = curr;
                zero = zero.next;
            } else if (curr.val == 1) {
                one.next = curr;
                one = one.next;
            } else {
                two.next = curr;
                two = two.next;
            }
            curr = curr.next;
        }

        // Step 2: Connect 0s → 1s → 2s
        zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null; // End of list

        // Step 3: Return new head
        return zeroHead.next;
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
        SortLinkedList012V2 obj = new SortLinkedList012V2();

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
