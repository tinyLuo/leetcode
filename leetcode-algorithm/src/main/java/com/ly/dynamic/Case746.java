package com.ly.dynamic;

/**
 * 
 * 使用最小花费爬楼梯 
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 * @author ly
 *
 */
public class Case746 {
    
    public int minCostClimbingStairs(int[] cost) {
        if(cost == null || cost.length == 0) {
            return 0;
        }
        int len = cost.length;
        if(len == 2) {
            return Math.min(cost[0], cost[1]);
        }
        int[] dp = new int[cost.length];
        dp[0] = 0;
        dp[1] = Math.min(cost[0], cost[1]);
        for(int i = 2 ; i < cost.length ; i++) {
            dp[i] = Math.min(cost[i] + dp[i-1], cost[i-1] + dp[i-2]);
        }
        return dp[cost.length - 1];
    }
    
    public static void main(String[] args) {
        Case746 case746 = new Case746();
        System.out.println(case746.minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
    
}
