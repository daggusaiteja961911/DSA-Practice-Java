package org.example.BinaryTrees;


import java.util.*;

class MaximumWidthOfBinaryTree {
    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        int maxWidth = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            int minIndex = q.peek().index;  // index of first node in level
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair current = q.poll();
                TreeNode node = current.node;
                int index = current.index - minIndex; // normalize to prevent overflow

                if (i == 0) first = index;
                if (i == size - 1) last = index;

                if (node.left != null)
                    q.add(new Pair(node.left, index * 2 + 1));
                if (node.right != null)
                    q.add(new Pair(node.right, index * 2 + 2));
            }

            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return maxWidth;
    }

    // Helper class for node + index
    static class Pair {
        TreeNode node;
        int index;
        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    // --- main for testing ---
    public static void main(String[] args) {

        /*
                  1
                /   \
               3     2
              / \     \
             5   3     9
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        System.out.println(widthOfBinaryTree(root)); // Output: 4
    }
}
