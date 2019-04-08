package com.ly.bfs;

import java.awt.image.RescaleOp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * 
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * 二叉树的层次遍历
 * @author ly
 *
 */
public class Case102 {
    
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        return res;
        
    }
    
    private static void bfs(TreeNode root, List<List<Integer>> res) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            List<TreeNode> list = new ArrayList<>();
            while (!queue.isEmpty()) {
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
