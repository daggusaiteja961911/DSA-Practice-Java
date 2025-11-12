package org.example.BinaryTrees;

class balancedBinaryTree {

    // Function to find height of a tree
    static int height(TreeNode root) {
        if (root == null) return 0;

        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left, right) + 1;
    }

    // Function to check if tree is balanced
    static boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // if current node not balanced → return false
        if (Math.abs(leftHeight - rightHeight) > 1)
            return false;

        // check for left and right subtree
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static void main(String[] args) {
        // Example
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(8);

        System.out.println(isBalanced(root));  // false
    }
}

