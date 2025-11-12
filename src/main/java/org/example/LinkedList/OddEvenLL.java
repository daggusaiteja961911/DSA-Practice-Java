package org.example.LinkedList;

//Odd Even Position Linked List
public class OddEvenLL {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode odd = head;            // Pointer for odd nodes
        ListNode even = head.next;      // Pointer for even nodes
        ListNode evenHead = even;       // Save head of even list to attach later

        while (even != null && even.next != null) {
            odd.next = even.next;       // Link next odd
            odd = odd.next;             // Move odd pointer
            even.next = odd.next;       // Link next even
            even = even.next;           // Move even pointer
        }

        odd.next = evenHead; // Attach even list at the end of odd list
        return head;
    }

    // Helper method to print list
    public void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + (temp.next != null ? " -> " : ""));
            temp = temp.next;
        }
        System.out.println();
    }

    // Main method for IntelliJ
    public static void main(String[] args) {
        OddEvenLL obj = new OddEvenLL();

        // Input list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));

        System.out.print("Original List: ");
        obj.printList(head);

        ListNode result = obj.oddEvenList(head);

        System.out.print("Odd-Even List: ");
        obj.printList(result);
    }
}

