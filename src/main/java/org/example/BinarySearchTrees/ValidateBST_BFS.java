package org.example.BinarySearchTrees;

import java.util.*;

class ValidateBST_BFS {
    static class NodeBounds {
        TreeNode node;
        long min, max;
        NodeBounds(TreeNode n, long min, long max) {
            this.node = n;
            this.min = min;
            this.max = max;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        Queue<NodeBounds> q = new LinkedList<>();
        q.add(new NodeBounds(root, Long.MIN_VALUE, Long.MAX_VALUE));

        while (!q.isEmpty()) {
            NodeBounds nb = q.poll();
            TreeNode node = nb.node;

            if (node.val <= nb.min || node.val >= nb.max)
                return false;

            if (node.left != null)
                q.add(new NodeBounds(node.left, nb.min, node.val));

            if (node.right != null)
                q.add(new NodeBounds(node.right, node.val, nb.max));
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        ValidateBST_BFS sol = new ValidateBST_BFS();
        System.out.println("Is Valid BST (BFS)? " + sol.isValidBST(root));
    }
}

