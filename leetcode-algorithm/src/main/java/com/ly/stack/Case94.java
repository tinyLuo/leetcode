package com.ly.stack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Case94 {
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        //midForeach(root, res);
        midForeachItr(root, res);
        return res;
    }
    
    
    public void midForeach(TreeNode root, List<Integer> res) {
        if(root == null) {
            return;
        }
        midForeach(root.left, res);
        res.add(root.val);
        midForeach(root.right, res);
    }
    
    public void midForeachItr(TreeNode root, List<Integer> res) {
        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();
        
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if(visited.contains(cur)) continue;
            TreeNode left = cur.left;
            if(left == null || visited.contains(left)) {
                res.add(cur.val);
                visited.add(cur);
                TreeNode right = cur.right;
                if(right != null) {
                    stack.push(right);
                }
            }else {
                stack.push(cur);
                stack.push(left);
            }
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
