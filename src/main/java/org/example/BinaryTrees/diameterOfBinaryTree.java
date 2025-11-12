package org.example.BinaryTrees;

class diamerterOfBinaryTree {
    static int diameter = 0; // global variable to store max diameter

    public static int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter; // in edges
    }

    // Helper function to get height
    private static int height(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // update diameter at this node
        diameter = Math.max(diameter, leftHeight + rightHeight);

        // return height of current node
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        // Example Tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Diameter = " + diameterOfBinaryTree(root)); // Output: 3
    }
}
