package org.example.DoublyLinkedList;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class AddTwoNumbersV1 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // dummy node to simplify
        ListNode current = dummy;
        int carry = 0;

        // Traverse both lists
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10; // carry for next addition
            current.next = new ListNode(sum % 10); // store digit
            current = current.next;
        }

        return dummy.next; // return head of result
    }

    // 🔹 Helper: print list
    public void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + (temp.next != null ? " -> " : ""));
            temp = temp.next;
        }
        System.out.println();
    }

    // 🔹 Main method for IntelliJ
    public static void main(String[] args) {
        AddTwoNumbersV1 obj = new AddTwoNumbersV1();

        // First number: 342 (stored as 2 -> 4 -> 3)
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));

        // Second number: 465 (stored as 5 -> 6 -> 4)
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode result = obj.addTwoNumbers(l1, l2);

        System.out.print("Result: ");
        obj.printList(result);
    }
}

