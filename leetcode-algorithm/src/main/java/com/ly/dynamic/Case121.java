package com.ly.dynamic;

/**
 * 
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/ 买卖股票的最佳时机
 * 
 * @author ly
 *
 */
public class Case121 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                max = Math.max(max, prices[i] - min);
            }
        }
        return max;
    }

}
