package org.example.BinaryTrees;


import java.util.LinkedList;
import java.util.Queue;

class Solution1 {
    public int maxDepthwithRecursion(TreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            depth++; // after each level
        }

        return depth;
    }


    public static void main(String[] args) {
        /*
                3
               / \
              9  20
                /  \
               15   7
        */
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution1 sol = new Solution1();
        System.out.println("Maximum Depth = " + sol.maxDepth(root));
        System.out.println(("Maximum Depth with Recursion = " + sol.maxDepthwithRecursion(root)));
    }
}
