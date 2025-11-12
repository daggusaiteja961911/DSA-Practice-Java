package org.example.BinarySearchTrees;

import java.util.*;

public class MaximumBST {
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> stack = new ArrayDeque<>();

        for (int num : nums) {
            TreeNode current = new TreeNode(num);

            // Step 1: Pop smaller nodes — they become left child of current
            while (!stack.isEmpty() && stack.peek().val < num) {
                current.left = stack.pop();
            }

            // Step 2: If stack not empty, top becomes parent — attach current as right child
            if (!stack.isEmpty()) {
                stack.peek().right = current;
            }

            // Step 3: Push current to stack
            stack.push(current);
        }

        // Step 4: The bottom of the stack will be the root
        return stack.isEmpty() ? null : stack.removeLast();
    }

    // BFS Traversal just to print & verify
    public static void bfsPrint(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            System.out.print(node.val + " ");
            if (node.left != null) q.offer(node.left);
            if (node.right != null) q.offer(node.right);
        }
    }

    // MAIN FUNCTION (for IntelliJ)
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 0, 5};
        TreeNode root = constructMaximumBinaryTree(nums);
        System.out.println("BFS Traversal of Constructed Tree:");
        bfsPrint(root);
    }
}

