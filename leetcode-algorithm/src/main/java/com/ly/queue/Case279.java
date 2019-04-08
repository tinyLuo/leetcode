package com.ly.queue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * https://leetcode-cn.com/problems/perfect-squares/
 * 完全平方数
 * @author ly
 *
 */
public class Case279 {
    
    public static int numSquares(int n) {
        if(n==0) {
            return 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        
        Set<Integer> visited = new HashSet<>();
        queue.add(0);
        visited.add(0);
        int step = 0;
        
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            step++;
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for(int i = 1; i*i + cur <= n; i++) {
                    int data = i*i + cur;
                    if(data == n) {
                        return step;
                    }
                    if(!visited.contains(data)) {
                        level.add(data);
                    }
                    visited.add(data);
                }
            }
            queue.addAll(level);
        }
        return step;
    }
    
    public static void main(String[] args) {
        System.out.println(numSquares(1));
        System.out.println(numSquares(2));
        System.out.println(numSquares(3));
        System.out.println(numSquares(4));
        System.out.println(numSquares(1029282));
        
    }
    
}
