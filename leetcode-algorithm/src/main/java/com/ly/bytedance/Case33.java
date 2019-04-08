package com.ly.bytedance;

/**
 * 
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * 搜索旋转排序数组
 * @author ly
 *
 */
public class Case33 {
    
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int pos = (nums.length - 1) / 2, left = 0 , right = nums.length - 1;
        while (pos > left && pos < right) {
            if(nums[pos] > nums[left]) {
            }
        }
        return 0;
        
    }
    
}
