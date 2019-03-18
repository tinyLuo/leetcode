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
        int fstBuy = Integer.MIN_VALUE, fstSell = 0;
        int secBuy = Integer.MIN_VALUE, secSell = 0;
        for (int p : prices) {
            fstBuy = Math.max(fstBuy, -p);
            fstSell = Math.max(fstSell, fstBuy + p);
            secBuy = Math.max(secBuy, fstSell - p);
            secSell = Math.max(secSell, secBuy + p);
        }
        return secSell;
    }

    public static void main(String[] args) {
        Case123 case123 = new Case123();
        // System.out.println(case123.maxProfit(new int[]{3,3,5,0,0,3,1,4}));
        // System.out.println(case123.maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(case123.maxProfit(new int[] { 1, 2, 4, 2, 5, 7, 2, 4, 9, 0 }));
    }

}
