//package org.example;
//
//
//import java.util.*;
//
//
//
//class Pair {
//    TreeNode node;
//    int state;
//    Pair(TreeNode node, int state) {
//        this.node = node;
//        this.state = state;
//    }
//}
//
//public class AllTraversals {
//    public static void allTraversal(TreeNode root) {
//        if (root == null) return;
//
//        Stack<Pair> stack = new Stack<>();
//        stack.push(new Pair(root, 1));
//
//        List<Integer> preorder = new ArrayList<>();
//        List<Integer> inorder = new ArrayList<>();
//        List<Integer> postorder = new ArrayList<>();
//
//        while (!stack.isEmpty()) {
//            Pair top = stack.pop();
//
//            if (top.state == 1) {
//                // PREORDER → Root
//                preorder.add(top.node.val);
//                top.state++; // move to next state
//                stack.push(top); // push back current node
//
//                // Left child next
//                if (top.node.left != null) {
//                    stack.push(new Pair(top.node.left, 1));
//                }
//            }
//            else if (top.state == 2) {
//                // INORDER → Left done, now Root
//                inorder.add(top.node.val);
//                top.state++;
//                stack.push(top);
//
//                // Right child next
//                if (top.node.right != null) {
//                    stack.push(new Pair(top.node.right, 1));
//                }
//            }
//            else {
//                // POSTORDER → Left & Right done
//                postorder.add(top.node.val);
//            }
//        }
//
//        System.out.println("Preorder:  " + preorder);
//        System.out.println("Inorder:   " + inorder);
//        System.out.println("Postorder: " + postorder);
//    }
//
//    public static void main(String[] args) {
//        // Tree:
//        //        1
//        //       / \
//        //      2   3
//        //     / \
//        //    4   5
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//
//        allTraversal(root);
//    }
//}
