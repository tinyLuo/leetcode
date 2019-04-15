package com.ly.binarytree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import com.ly.binarytree.PreOrder.TreeNode;

public class InOrder {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited =  new HashSet<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if(node.left != null && !visited.contains(node.left)) {
                stack.push(node.left);
            }else {
                stack.pop();
                list.add(node.val);
                visited.add(node);
                if(node.right != null) {
                    stack.push(node.right);
                }
            }
        }
        return list;
    }
}
