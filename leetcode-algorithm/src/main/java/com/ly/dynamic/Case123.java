package com.ly.dynamic;

/**
 * 
 * 买卖股票的最佳时机 III
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 * 
 * @author ly
 *
 */
public class Case123 {

    // public int maxProfit(int[] prices) {
    // // prices[n,m], prices[n,x] + prices[x+1,m]
    // if(prices == null || prices.length < 2) {
    // return 0;
    // }
    // int buy = Integer.MAX_VALUE;
    // int out = Integer.MIN_VALUE;
    // int one = 0;//最高收益
    // int second = 0;//次高收益
    // for(int i = 0; i < prices.length; i++) {
    // if(prices[i] <= buy && out == Integer.MIN_VALUE) {
    // buy = prices[i];
    // }else if(prices[i] > out){
    // out = prices[i];
    // }else {
    // int profile = out - buy;
    // if(profile > one) {
    // second = one;
    // one = profile;
    // }else if (profile > second) {
    // second = profile;
    // }
    // buy = prices[i];
    // out = Integer.MIN_VALUE;
    // }
    // }
    // //最后看需不需要再卖出
    // if(out != Integer.MIN_VALUE) {
    // int fp = out - buy;
    // if(fp > one) {
    // second = one;
    // one = fp;
    // }else if (fp > second) {
    // second = fp;
    // }
    // }
    // return second + one;
    // }

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int[] dp = new int[prices.length];
        int min = prices[0];
        //1-i 天的最大收益
        for(int i = 1 ; i < prices.length; i++) {
            if(prices[i] < min) {
                min = prices[i];
                dp[i] = dp[i-1];
            }else {
                dp[i] = Math.max(dp[i-1], prices[i] - min);
            }
        }
        
        int[] dp2 = new int[prices.length];
        int max = prices[prices.length-1];
        for(int j = prices.length -2 ; j > 0 ; j--) {
            if(prices[j] > max) {
                max = prices[j];
                dp2[j] = dp2[j+1];
            }else {
                dp2[j] = Math.max(dp2[j+1], max - prices[j]);
            }
        }
        int sumMax = 0;
        for(int i = 1 ; i < prices.length -2 ; i ++) {
            sumMax = Math.max(sumMax, dp[i] + dp2[i+1]);
        }
        sumMax = Math.max(sumMax, dp[prices.length-1]);
        return sumMax;
    }

    public static void main(String[] args) {
        Case123 case123 = new Case123();
        // System.out.println(case123.maxProfit(new int[]{3,3,5,0,0,3,1,4}));
        // System.out.println(case123.maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(case123.maxProfit(new int[] {1,4,2,7 }));
    }

}
