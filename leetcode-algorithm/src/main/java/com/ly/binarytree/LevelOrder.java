package com.ly.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.ly.binarytree.PreOrder.TreeNode;

public class LevelOrder {
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            List<TreeNode> list = new ArrayList<>();
            List<Integer> levelRes = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                levelRes.add(node.val);
                if(node.left != null) {
                    list.add(node.left);
                }
                if(node.right != null) {
                    list.add(node.right);
                }
            }
            res.add(levelRes);
            queue.addAll(list);
        }
        return res;
        
    }
    
}
