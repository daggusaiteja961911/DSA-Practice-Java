package org.example.BinarySearchTrees;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}


class SearchInBST {
    public static TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) {
                return root; // found
            } else if (val < root.val) {
                root = root.left; // go left
            } else {
                root = root.right; // go right
            }
        }
        return null; // not found
    }

    public static void main(String[] args) {
        // Build BST
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);


        TreeNode found = searchBST(root, 6);

        if (found != null)
            System.out.println("Found Node: " + found.val);
        else
            System.out.println("Node not found!");
    }
}

