package com.ly.array;

/**
 * 
 * https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/1/array/22/
 * @author ly
 *
 */
public class Code2 {
    
    public static void main(String[] args) {
        Code2 code2 = new Code2();
        int[] arr = {7,6,4,3,1};
        System.out.println(code2.maxProfit(arr));
    }
    
    public int maxProfit(int[] prices) {
    		if(prices == null || prices.length == 0) {
    			return 0;
    		}
        int buy = Integer.MAX_VALUE;
        int out = 0;
        int sale = 0;
        for(int i = 0 ; i < prices.length ; i++) {
            //1. 找到买入点
            if(buy > prices[i] && out == 0) {
                buy = prices[i];
            }else if (out < prices[i]) {
                //2. 找到卖出点
                out = prices[i];
            }else {
                //3. 卖出时机
                sale += out - buy;
                buy = prices[i];
                out = 0;
            }
        }
        if(out != 0) {
        		sale += out - buy;
        }
        return sale;
    }
}
