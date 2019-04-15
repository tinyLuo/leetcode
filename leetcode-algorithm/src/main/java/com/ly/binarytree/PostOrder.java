package com.ly.binarytree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import com.ly.binarytree.PreOrder.TreeNode;

public class PostOrder {

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> set = new HashSet<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if(cur.right != null && !set.contains(cur.right)) {
                stack.push(cur.right);
            }
            if(cur.left != null && !set.contains(cur.left)) {
                stack.push(cur.left);
            }
            if((cur.left == null || set.contains(cur.left)) && (cur.right == null || set.contains(cur.right))) {
                stack.pop();
                list.add(cur.val);
                set.add(cur);
            }
        }
        return list;
    }
    
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(3);
        postorderTraversal(node);
    }
    
}
