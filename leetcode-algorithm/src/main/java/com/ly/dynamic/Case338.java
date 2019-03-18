package com.ly.dynamic;

import java.util.Arrays;

/**
 * 
 * 比特位计数
 * https://leetcode-cn.com/problems/counting-bits/
 * @author ly
 *
 */
public class Case338 {
    
    public int[] countBits(int num) {
        //对于偶数 n, 末尾一定是 0 ，n >> 1 的 1 的个数
        //对于奇数 n, 末尾一定是 1 ，dp[n] = dp[n-1] + 1;
        int[] dp = new int[num+1];
        for(int i = 1 ; i <= num ; i++) {
            if(i % 2 == 0) {
                dp[i] = dp[i >> 1];
            }else {
                dp[i] = dp[i-1] + 1;
            }
        }
        return dp;
    }
    
}
