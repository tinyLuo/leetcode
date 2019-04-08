package com.ly.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 * N叉树的最大深度
 * @author ly
 *
 */
public class Case559 {

    public static int maxDepth(Node root) {
        if(root == null) return 0;
        return bfs(root);
    }
    
    //bfs 解决
    public static int bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        int size = 0;
        while (!queue.isEmpty()) {
            size++;
            List<Node> level = new ArrayList<>();
            while (!queue.isEmpty()) {
                Node cur = queue.poll();
                if(null != cur.children) {
                    level.addAll(cur.children);
                }
            }
            for(Node child : level) {
                if(child == null) continue;
                queue.add(child);
            }
        }
        return size;
    }
    
    
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
