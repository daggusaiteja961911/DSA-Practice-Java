package org.example.BinarySearchTrees;

import java.util.*;

// Definition for binary tree node

class DeleteNodeInBST {

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        // If deleting root itself
        if (root.val == key) return deleteRoot(root);

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            // Check left child
            if (node.left != null) {
                if (node.left.val == key) {
                    node.left = deleteRoot(node.left);
                    break;
                } else {
                    q.offer(node.left);
                }
            }

            // Check right child
            if (node.right != null) {
                if (node.right.val == key) {
                    node.right = deleteRoot(node.right);
                    break;
                } else {
                    q.offer(node.right);
                }
            }
        }

        return root;
    }

    // Helper to handle deletion for the node itself
    private static TreeNode deleteRoot(TreeNode root) {
        // Case 1: No children
        if (root.left == null && root.right == null)
            return null;

        // Case 2: One child
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;

        // Case 3: Two children
        TreeNode parent = root;
        TreeNode successor = root.right;

        // Find smallest value in right subtree
        while (successor.left != null) {
            parent = successor;
            successor = successor.left;
        }

        // Replace root value
        root.val = successor.val;

        // Delete the successor node
        if (parent.left == successor)
            parent.left = successor.right;
        else
            parent.right = successor.right;

        return root;
    }

    // Print inorder (for testing)
    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        // Build BST
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(12);
        root.right.left.left = new TreeNode(11);

        System.out.println("Before Deletion (Inorder): ");
        inorder(root);
        System.out.println();

        // Delete key = 3
        root = deleteNode(root, 10);

        System.out.println("After Deletion (Inorder): ");
        inorder(root);

//        // Test 1: Delete leaf node
//        TreeNode root1 = new TreeNode(5);
//        root1.left = new TreeNode(3);
//        root1.right = new TreeNode(6);
//        root1.left.left = new TreeNode(2);
//        root1.left.right = new TreeNode(4);
//        root1.right.right = new TreeNode(7);
//
//        System.out.println("Test 1: Delete leaf node (4)");
//        inorder(root1);
//        System.out.println();
//        root1 = deleteNode(root1, 4);
//        inorder(root1);
//        System.out.println();

//        // Test 2: Delete node with one child
//        TreeNode root2 = new TreeNode(5);
//        root2.left = new TreeNode(3);
//        root2.right = new TreeNode(6);
//        root2.left.left = new TreeNode(2);
//        // 3 only has left child
//        System.out.println("\nTest 2: Delete node with one child (3)");
//        inorder(root2);
//        System.out.println();
//        root2 = deleteNode(root2, 3);
//        inorder(root2);
//        System.out.println();
//
//        // Test 3: Delete node with two children (root)
//        TreeNode root3 = new TreeNode(5);
//        root3.left = new TreeNode(3);
//        root3.right = new TreeNode(6);
//        root3.left.left = new TreeNode(2);
//        root3.left.right = new TreeNode(4);
//        root3.right.right = new TreeNode(7);
//
//        System.out.println("\nTest 3: Delete node with two children (5, root)");
//        inorder(root3);
//        System.out.println();
//        root3 = deleteNode(root3, 5);
//        inorder(root3);
//        System.out.println();
//
//        // Test 4: Delete node not present
//        TreeNode root4 = new TreeNode(2);
//        root4.right = new TreeNode(3);
//
//        System.out.println("\nTest 4: Delete node not present (99)");
//        inorder(root4);
//        System.out.println();
//        root4 = deleteNode(root4, 99);
//        inorder(root4);
//        System.out.println();
//
//        // Test 5: Delete root node when root is leaf
//        TreeNode root5 = new TreeNode(10);
//
//        System.out.println("\nTest 5: Delete root leaf node (10)");
//        inorder(root5);
//        System.out.println();
//        root5 = deleteNode(root5, 10);
//        inorder(root5);
//        System.out.println();
//
//        // Test 6: Delete root node with one right child
//        TreeNode root6 = new TreeNode(10);
//        root6.right = new TreeNode(12);
//
//        System.out.println("\nTest 6: Delete root node with only right child (10)");
//        inorder(root6);
//        System.out.println();
//        root6 = deleteNode(root6, 10);
//        inorder(root6);
//        System.out.println();
//
//        // Test 7: Delete root node with one left child
//        TreeNode root7 = new TreeNode(10);
//        root7.left = new TreeNode(8);
//
//        System.out.println("\nTest 7: Delete root node with only left child (10)");
//        inorder(root7);
//        System.out.println();
//        root7 = deleteNode(root7, 10);
//        inorder(root7);
//        System.out.println();
    }
}

