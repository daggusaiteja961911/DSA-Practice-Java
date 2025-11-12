package org.example.BinarySearchTrees;

import java.util.*;


public class KthElementBST {

    // ------------------ Kth Smallest ------------------
    static int countSmall = 0;
    static int ansSmall = -1;

    public static int kthSmallest(TreeNode root, int k) {
        countSmall = 0;
        ansSmall = -1;
        inorder(root, k);
        return ansSmall;
    }

    private static void inorder(TreeNode root, int k) {
        if (root == null) return;

        inorder(root.left, k);

        countSmall++;
        if (countSmall == k) {
            ansSmall = root.val;
            return;
        }

        inorder(root.right, k);
    }

    // ------------------ Kth Largest ------------------
    static int countLarge = 0;
    static int ansLarge = -1;

    public static int kthLargest(TreeNode root, int k) {
        countLarge = 0;
        ansLarge = -1;
        reverseInorder(root, k);
        return ansLarge;
    }

    private static void reverseInorder(TreeNode root, int k) {
        if (root == null) return;

        reverseInorder(root.right, k);

        countLarge++;
        if (countLarge == k) {
            ansLarge = root.val;
            return;
        }

        reverseInorder(root.left, k);
    }

    // ------------------ MAIN FUNCTION ------------------
    public static void main(String[] args) {
        /*
                5
               / \
              3   7
             / \   \
            2   4   8
        */
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(8);

        int k1 = 3;
        int k2 = 2;

        System.out.println("Kth Smallest (" + k1 + "): " + kthSmallest(root, k1));
        //System.out.println("Kth Largest (" + k2 + "): " + kthLargest(root, k2));
    }
}

