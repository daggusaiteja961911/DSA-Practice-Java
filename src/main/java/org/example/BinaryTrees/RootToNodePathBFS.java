package org.example.BinaryTrees;

import java.util.*;

public class RootToNodePathBFS {

    public static List<Integer> rootToNodePath(TreeNode root, int target) {
        if (root == null) return Collections.emptyList();

        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        parentMap.put(root, null);  // root has no parent
        TreeNode targetNode = null;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.val == target) {
                targetNode = node;
                break;
            }

            if (node.left != null) {
                parentMap.put(node.left, node);
                queue.add(node.left);
            }
            if (node.right != null) {
                parentMap.put(node.right, node);
                queue.add(node.right);
            }
        }

        // If target not found
        if (targetNode == null) return Collections.emptyList();

        // Retrace path from target -> root using parent map
        List<Integer> path = new ArrayList<>();
        TreeNode curr = targetNode;
        while (curr != null) {
            path.add(curr.val);
            curr = parentMap.get(curr);
        }

        // Reverse the list to get root -> target
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        // Build tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int target = 5;
        List<Integer> path = rootToNodePath(root, target);

        if (path.isEmpty())
            System.out.println("Node not found.");
        else
            System.out.println("Path from root to node " + target + ": " + path);
    }
}

