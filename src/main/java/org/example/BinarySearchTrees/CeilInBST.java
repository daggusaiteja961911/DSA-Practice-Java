package org.example.BinarySearchTrees;

public class CeilInBST {

    public static int findCeil(TreeNode root, int key) {
        int ceil = -1;

        while (root != null) {
            if (root.val == key) {
                ceil = root.val;
                break;
            } else if (root.val < key) {
                root = root.right;
            } else { // root.val > key
                ceil = root.val;
                root = root.left;
            }
        }

        return ceil;
    }

    public static void main(String[] args) {
        // Create BST
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(14);

        int key = 5;
        int ceil = findCeil(root, key);
        System.out.println("Ceil of " + key + " is: " + ceil);
    }
}
