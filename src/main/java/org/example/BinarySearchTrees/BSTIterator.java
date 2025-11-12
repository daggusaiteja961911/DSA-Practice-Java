package org.example.BinarySearchTrees;

import java.util.Stack;

// BST Iterator class
class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();

    // Constructor: push all left children of root
    public BSTIterator(TreeNode root) {
        pushAllLeft(root);
    }

    // Push all left nodes into the stack
    private void pushAllLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    // Return true if there are more nodes
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    // Return next smallest number
    public int next() {
        TreeNode top = stack.pop();
        // If there's a right child, push all its left nodes
        if (top.right != null)
            pushAllLeft(top.right);
        return top.val;
    }

    public static void main(String[] args) {
        // Construct BST
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        // Create iterator
        BSTIterator iterator = new BSTIterator(root);

        // Output (should print: 3, 7, 9, 15, 20)
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}

