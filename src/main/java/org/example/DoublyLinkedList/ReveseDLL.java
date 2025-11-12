package org.example.DoublyLinkedList;

public class ReveseDLL {

    // 🔹 Reverse DLL
    public DoublyNode reverse(DoublyNode head) {
        if (head == null || head.next == null) return head;

        DoublyNode current = head;
        DoublyNode temp = null;

        // Swap next and prev for all nodes
        while (current != null) {
            temp = current.prev;          // store previous
            current.prev = current.next;  // swap prev and next
            current.next = temp;          // connect swapped pointers
            current = current.prev;       // move forward (since swapped)
        }

        // After loop, temp is at the node *before* new head
        if (temp != null) {
            head = temp.prev;
        }

        return head;
    }

    // 🔹 Print List (forward)
    public void printList(DoublyNode head) {
        DoublyNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // 🔹 Main method to test
    public static void main(String[] args) {
        ReveseDLL dll = new ReveseDLL();

        // Manually creating DLL: 10 <-> 20 <-> 30 <-> 40
        DoublyNode n1 = new DoublyNode(10);
        DoublyNode n2 = new DoublyNode(20);
        DoublyNode n3 = new DoublyNode(30);
        DoublyNode n4 = new DoublyNode(40);

        n1.next = n2; n2.prev = n1;
        n2.next = n3; n3.prev = n2;
        n3.next = n4; n4.prev = n3;

        DoublyNode head = n1;

        System.out.print("Original List: ");
        dll.printList(head);

        head = dll.reverse(head);

        System.out.print("Reversed List: ");
        dll.printList(head);
    }
}
