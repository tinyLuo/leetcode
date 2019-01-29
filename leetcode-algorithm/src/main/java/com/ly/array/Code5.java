package com.ly.array;

import java.util.Arrays;

/**
 * 
 * https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/1/array/25/
 * @author ly
 *
 */
public class Code5 {
	// 还可以用 异或 来做，效率更高
	public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
        		return 0;
        }
        if(nums.length == 1) {
        		return nums[0];
        }
        Arrays.sort(nums);
        for(int i = 1 ; i < nums.length-1 ; i++) {
        		if(nums[i] != nums[i-1] && nums[i] != nums[i+1]) {
        			return nums[i];
        		}
        }
        if(nums[0] != nums[1]) {
        		return nums[0];
        }
    		return nums[nums.length-1];
    }
}
