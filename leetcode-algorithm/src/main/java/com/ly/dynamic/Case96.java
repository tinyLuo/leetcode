package com.ly.dynamic;


/**
 * 
 * 不同的二叉搜索树
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 * @author ly
 *
 */
public class Case96 {

    //error
    public int numTrees_e(int n) {
        //f(x) = 3*f(x-1) - f(x-2)
        if(n <= 0) {
            return 0;
        }
        if(n == 1 || n == 2) {
            return n;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i < dp.length ; i++) {
            dp[i] = 3 * dp[i-1] - dp[i-2];
        }
        return dp[n];
    }
    
    public static int numTrees(int n) {
        if(n < 0) {
            return 0;
        }
        if(n <= 2) {
            return n;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2 ; i < dp.length ; i++) {
            for(int j = 1 ; j <= i ; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
    
    public static void main(String[] args) {
        for(int i = 0 ; i < 10 ; i++) {
            System.out.println(i + "：" + numTrees(i));
        }
    }
}
