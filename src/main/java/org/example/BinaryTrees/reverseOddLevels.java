package org.example.BinaryTrees;

import java.util.*;

class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> levelNodes = new ArrayList<>();

            // Step 1: Collect all nodes of this level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelNodes.add(node);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            // Step 2: Reverse node values at odd levels
            if (level % 2 == 1) {
                int left = 0, right = levelNodes.size() - 1;
                while (left < right) {
                    int temp = levelNodes.get(left).val;
                    levelNodes.get(left).val = levelNodes.get(right).val;
                    levelNodes.get(right).val = temp;
                    left++;
                    right--;
                }
            }

            level++;
        }

        return root;
    }

        public static void main(String[] args) {
            /*
                     2
                   /   \
                  3     5
                 / \   / \
                8  13 21  34
            */

            TreeNode root = new TreeNode(2);
            root.left = new TreeNode(3);
            root.right = new TreeNode(5);
            root.left.left = new TreeNode(8);
            root.left.right = new TreeNode(13);
            root.right.left = new TreeNode(21);
            root.right.right = new TreeNode(34);

            Solution sol = new Solution();
            TreeNode newRoot = sol.reverseOddLevels(root);

            // Print level order traversal after reversing
            printLevelOrder(newRoot);
        }

        // Helper function to print tree in level order
        public static void printLevelOrder(TreeNode root) {
            if (root == null) return;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    System.out.print(node.val + " ");
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
            }
        }

}

