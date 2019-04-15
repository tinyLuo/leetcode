package com.ly.binarytree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import com.ly.binarytree.PreOrder.TreeNode;

public class Case113 {

    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Map<TreeNode, Integer> sumMap = new HashMap<>();
        Map<TreeNode, TreeNode> parenMap = new HashMap<>();
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int val = sumMap.getOrDefault(parenMap.get(node), 0) + node.val;
            sumMap.put(node, val);
            if(node.left != null) {
                parenMap.put(node.left, node);
                stack.push(node.left);
            }
            
            if(node.right != null) {
                parenMap.put(node.right, node);
                stack.push(node.right);
            }
            if(node.right == null && node.left == null) {
                if(val == sum) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.left.left = new TreeNode(11);
        node.left.left.left = new TreeNode(7);
        node.left.left.right = new TreeNode(2);
        node.right = new TreeNode(8);
        node.right.left = new TreeNode(13);
        node.right.right = new TreeNode(4);
        node.right.right.right = new TreeNode(1);
        hasPathSum(node, 22);
    }
    
}
