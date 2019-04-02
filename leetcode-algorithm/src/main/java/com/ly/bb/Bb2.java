package com.ly.bb;

/**
 * 
 * https://forzfu.github.io/2017/09/15/%E8%83%8C%E5%8C%85%E4%B9%9D%E8%AE%B2/
 * @author ly
 *
 */
public class Bb2 {

    // 完全背包
    public static int optimal1(int wt, int[] w, int[] v) {
        //dp[i][j] = Math.max(dp[i-1][j-k*wi] + k*vi) 0 <= k <= j/wi
        int[][] dp = new int[w.length][wt+1];
        
        //初始化
        for(int i = w[0] ; i <= wt ; i++) {
            dp[0][i] = v[0] * i / w[0];
        }
        
        //状态流转
        for(int i = 1 ; i < w.length ; i++) {
            for(int j = wt ; j > 0 ; j--) {
                int maxK = j / w[i];
                for(int k = 0 ; k <= maxK ; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j - k*w[i]] + k*v[i]);
                }
            }
        }
        
        return dp[w.length-1][wt];
    }
    
    // 完全背包优化
    public static int optimal2(int wt, int[] w, int[] v) {
        //dp[i][j] = Math.max(dp[i-1][j], dp[i][j-wi]+vi)
        int[][] dp = new int[w.length][wt+1];
        
        //初始化
        for(int i = w[0] ; i <= wt ; i++) {
            dp[0][i] = v[0] * i / w[0];
        }
        
        for(int i = 1 ; i < w.length ; i++) {
            for(int j = 1; j <= wt ; j++) {
                if(j >= w[i]) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-w[i]]+v[i]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[w.length-1][wt];
    }
    
    
    public static void main(String[] args) {
        int wt = 10;
        int[] w = {1,2,4,3,7,5};
        int[] v = {1,3,6,4,10,7};
//        for(int i = 0 ; i < 30 ; i++) { 
//            System.out.println(optimal1(i, w, v));
//            System.out.println(optimal2(i, w, v));
//        }
        System.out.println(optimal1(11, w, v));
        System.out.println(optimal2(11, w, v));
    }
}
