package com.ly.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrder {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        recursion(root, list);
        return list;
    }
    
    private void recursion(TreeNode node, List<Integer> list) {
        if(node == null) {
            return ;
        }
        list.add(node.val);
        recursion(node.left, list);
        recursion(node.right, list);
    }
    
    public List<Integer> preorderTraversalItr(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        itr(root, list);
        return list;
    }
    
    
    private void itr(TreeNode node, List<Integer> list) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if(cur == null) {
                continue;
            }
            list.add(cur.val);
            //stack.push(cur.left);
            stack.push(cur.right);
            stack.push(cur.left);
        }
    }
}
