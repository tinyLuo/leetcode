package com.ly.bb;

/**
 * 
 * 背包问题1：
 * 有n个重量和价值分别为 wi,vi 的物品。从这些物品中挑选出总重量不超过 W 的物品， 
 * 求所有挑选方案中价值总和的最大值。
 * @author ly
 *
 */
public class Bb1 {
    
    //01 背包问题解法1
    public static int optimal1(int wt, int[] w, int[] v) {
        // dp[i][wt] = max(dp[i-1][wt],dp[i-1][wt-wi] + vi)
        int[][] dp = new int[w.length][wt+1];
        for(int i = 0 ; i < w.length ; i++) {
            for(int j = 1 ; j <= wt ; j++) {
                if(i == 0 && j >= w[i]) {
                    dp[i][j] = v[0];
                }else {
                    if(j < w[i]) {
                        dp[i][j] = dp[i-1][j];
                    }else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]] + v[i]);
                    }
                }
            }
        }
        return dp[w.length-1][wt];
    }
    
    //01 背包问题空间复杂度优化
    public static int optimal2(int wt, int[] w, int[] v) {
        // 第 i 行的结果只于 i-1 行有关只存 i-1 就行了
        int[] dp = new int[wt+1];
        //第一次初始化
        for(int j = w[0]; j <= wt ; j++) {
            dp[j] = v[0];
        }
        
        for(int i = 1 ; i < w.length ; i++) {
            for(int x = wt ; x > 0 ; x--) {
                if(x < w[i]) {
                    dp[x] = dp[x];
                }else {
                    dp[x] = Math.max(dp[x], dp[x-w[i]] + v[i]);
                }
            }
        }
        return dp[wt];
    }
    
    //01 背包刚好被填满的最大收益
    public static int optimal3(int wt, int[] w, int[] v) {
        int[] dp = new int[wt+1];
        for(int i= 1 ; i < dp.length ; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        
        if(w[0] <= wt) {
            dp[w[0]] = v[0];
        }
        
        for(int i = 1 ; i < w.length ; i++) {
            for(int x = wt ; x > 0 ; x--) {
                if(x >= w[i]) {
                    if(dp[x] != Integer.MIN_VALUE || dp[x-w[i]] != Integer.MIN_VALUE) {
                        dp[x] = Math.max(dp[x], dp[x-w[i]] + v[i]);
                    }
                }
            }
        }
        
        return dp[wt];
    }
    
    public static void main(String[] args) {
        int wt = 10;
        int[] w = {1,2,4,3,7,5};
        int[] v = {1,3,6,4,10,7};
//        for(int i = 0 ; i < 30 ; i++) { 
//            System.out.println(optimal1(i, w, v));
//            System.out.println(optimal2(i, w, v));
//        }
        System.out.println(optimal3(6, w, v));
    }
}
