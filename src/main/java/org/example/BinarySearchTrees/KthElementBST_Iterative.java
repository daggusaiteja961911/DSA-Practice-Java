package org.example.BinarySearchTrees;

import java.util.*;

public class KthElementBST_Iterative {

    // -------- Kth Smallest Element --------
    public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        // Inorder traversal (Left -> Root -> Right)
        while (true) {
            // Go to the leftmost node
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop(); // Visit node
            k--; // Count this node
            if (k == 0)
                return root.val; // Found kth smallest

            root = root.right; // Go right
        }
    }

    // -------- Kth Largest Element --------
    public static int kthLargest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        // Reverse inorder (Right -> Root -> Left)
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.right;
            }

            root = stack.pop();
            k--;
            if (k == 0)
                return root.val;

            root = root.left;
        }
    }

    // -------- MAIN FUNCTION --------
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

        int k1 = 3; // 3rd smallest
        int k2 = 2; // 2nd largest

        System.out.println("Kth Smallest (" + k1 + "): " + kthSmallest(root, k1));
        //0System.out.println("Kth Largest (" + k2 + "): " + kthLargest(root, k2));
    }
}
