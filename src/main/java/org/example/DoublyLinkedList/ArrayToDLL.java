package org.example.DoublyLinkedList;

class DoublyNode {
    int val;
    DoublyNode next;
    DoublyNode prev;

    // 1️⃣ Default constructor
    DoublyNode() {
    }

    // 2️⃣ Constructor with only value
    DoublyNode(int val) {
        this.val = val;
    }

    // 3️⃣ Constructor with value and next
    DoublyNode(int val, DoublyNode next) {
        this.val = val;
        this.next = next;
    }

    // 4️⃣ Constructor with value, next, and prev
    DoublyNode(int val, DoublyNode next, DoublyNode prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}

public class ArrayToDLL {
    // Convert array to DLL
    public static DoublyNode arrayToDoublyLinkedList(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;

        DoublyNode head = new DoublyNode(arr[0]);
        DoublyNode curr = head;

        for (int i = 1; i < arr.length; i++) {
            DoublyNode newNode = new DoublyNode(arr[i]);
            curr.next = newNode;
            newNode.prev = curr;
            curr = newNode;
        }

        return head;
    }

    // Print DLL forward
    public static void printForward(DoublyNode head) {
        DoublyNode curr = head;
        System.out.print("Forward: ");
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Print DLL backward (to verify prev links)
    public static void printBackward(DoublyNode tail) {
        DoublyNode curr = tail;
        System.out.print("Backward: ");
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        DoublyNode head = arrayToDoublyLinkedList(arr);

        // Move to tail for backward printing
        DoublyNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        printForward(head);
        printBackward(tail);
    }
}
