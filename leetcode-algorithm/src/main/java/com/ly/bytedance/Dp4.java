package com.ly.bytedance;

/**
 * 
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * @author ly
 *
 */
public class Dp4 {
    
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int sum = nums[0];
        int max = sum;
        for(int i = 1 ; i < len; i++) {
            if(sum > 0) {
                sum += nums[i];
            }else {
                sum = nums[i];
            }
            max = Math.max(sum, max);
        }
        return max;
    }
    
}
