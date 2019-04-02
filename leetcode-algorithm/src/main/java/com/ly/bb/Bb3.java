package com.ly.bb;

/**
 * 
 * 多重背包
 * https://forzfu.github.io/2017/09/15/%E8%83%8C%E5%8C%85%E4%B9%9D%E8%AE%B2/
 * @author ly
 *
 */
public class Bb3 {

    public static int optimal1(int wt, int[] w, int[] avai,int[] v) {
        //dp[i][j] = max(dp[i-1][j-k*wi] + k*vi) 0<= k <=min(avai[i], j/wi)
        int[][] dp = new int[w.length][wt+1];
        
        return dp[w.length-1][wt];
    }
}
