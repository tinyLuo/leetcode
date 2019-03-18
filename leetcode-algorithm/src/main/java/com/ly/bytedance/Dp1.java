package com.ly.bytedance;

/**
 * 
 * @author ly
 *
 */
public class Dp1 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
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

    public static void main(String[] args) {
        Dp1 dp1 = new Dp1();
        System.out.println(dp1.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
    }
}
