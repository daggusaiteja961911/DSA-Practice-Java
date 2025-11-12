package org.example.BinaryTrees;

import java.util.*;

// Definition for a binary tree node

class BinaryTreePath {
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<String> paths = new LinkedList<>();

        nodes.add(root);
        paths.add(String.valueOf(root.val));

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            String path = paths.poll();

            // If it's a leaf node → add the path to result
            if (node.left == null && node.right == null) {
                result.add(path);
            }

            // Add left child
            if (node.left != null) {
                nodes.add(node.left);
                paths.add(path + "->" + node.left.val);
            }

            // Add right child
            if (node.right != null) {
                nodes.add(node.right);
                paths.add(path + "->" + node.right.val);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Create sample tree:
        //        1
        //       / \
        //      2   3
        //       \
        //        5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        List<String> result = binaryTreePaths(root);

        System.out.println("All root-to-leaf paths: " + result);
    }
}
