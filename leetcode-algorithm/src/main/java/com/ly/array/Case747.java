package com.ly.array;

public class Case747 {
    public static int dominantIndex(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int maxIdx = 0;
        int max = nums[0];
        int sec = Integer.MIN_VALUE;
        
        for(int i = 1; i < nums.length ; i++) {
            if (nums[i] > sec) {
                sec = nums[i];
                if(nums[i] > max) {
                    sec = max;
                    max = nums[i];
                    maxIdx = i;
                }
            }
        }
        if(max >= sec * 2) {
            return maxIdx;
        }
        return -1;
    }
    
    public static void main(String[] args) {
        System.out.println(dominantIndex(new int[] {0,0,0,1}));
    }
}
