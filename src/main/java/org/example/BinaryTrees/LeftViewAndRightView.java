package org.example.BinaryTrees;

import java.util.*;

public class LeftViewAndRightView {
    public static void main(String[] args) {
        // 🌳 Build example binary tree
        /*
                1
               / \
              2   3
             / \   \
            4   5   6
                 \
                  7
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.right.right = new TreeNode(7);

        // 🧭 Print both views
        System.out.println("Left View of Binary Tree: " + leftView(root));
        System.out.println("Right View of Binary Tree: " + rightView(root));
    }

    // 👈 Left View (first node of each level)
    public static List<Integer> leftView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                // Add first node of each level
                if (i == 0) result.add(node.val);

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }
        return result;
    }

    // 👉 Right View (last node of each level)
    public static List<Integer> rightView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                // Add last node of each level
                if (i == size - 1) result.add(node.val);

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }
        return result;
    }
}

