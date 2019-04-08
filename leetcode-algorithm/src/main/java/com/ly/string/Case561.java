package com.ly.string;

import java.util.Arrays;

public class Case561 {
    
    public int arrayPairSum(int[] nums) {
        if(nums == null || nums.length % 2 != 0) {
            return 0;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 2;
        int sum = 0;
        while (left <= right) {
            if(left != right) {
                sum += nums[left] + nums[right];
            }else {
                sum = nums[left];
            }
            left += 2;
            right -= 2;
        }
        return sum;
    }
    
}
