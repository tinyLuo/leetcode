package com.ly.bytedance;

/**
 * 
 * @author ly
 *
 */
public class Dp2 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int profit = 0;
        int pre = prices[0];
        for (int i = 0; i < prices.length; i++) {
            int a = prices[i] - pre;
            if (a > 0) {
                profit += a;
            }
            pre = prices[i];
        }
        return profit;
    }
}
