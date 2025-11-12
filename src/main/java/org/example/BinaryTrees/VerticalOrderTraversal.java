package org.example.BinaryTrees;

import java.util.*;

// TreeNode definition

class VerticalOrderTraversal {
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        // column -> (row -> list of node values)
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();

        // Queue for BFS: node, column, row
        Queue<Object[]> queue = new LinkedList<>();
        queue.offer(new Object[]{root, 0, 0});

        while (!queue.isEmpty()) {
            Object[] arr = queue.poll();
            TreeNode node = (TreeNode) arr[0];
            int col = (int) arr[1];
            int row = (int) arr[2];

            if (node == null) continue;

            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new ArrayList<>());
            map.get(col).get(row).add(node.val);

            queue.offer(new Object[]{node.left, col - 1, row + 1});
            queue.offer(new Object[]{node.right, col + 1, row + 1});
        }

        // Prepare final result
        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, List<Integer>> rows : map.values()) {
            List<Integer> colList = new ArrayList<>();
            for (List<Integer> nodes : rows.values()) {
                Collections.sort(nodes); // sort by value if same row
                colList.addAll(nodes);
            }
            result.add(colList);
        }

        return result;
    }

    // Example main() to test in IntelliJ
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);


        System.out.println(verticalTraversal(root));
        // Output: [[9], [3, 15], [20], [7]]
    }
}

