package com.ly.binarysearch;

public class Case34 {
    
    public int[] searchRange(int[] nums, int target) {
        if (nums == null) {
            return new int[]{ -1, -1 };
        }
        int firstTarget = getNumIndex(nums, target, true);
        int lastTarget = getNumIndex(nums, target, false);
        return new int[]{ firstTarget, lastTarget };
    }
    
    public int getNumIndex(int[] nums, int target, boolean small) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (small == true) {
                    if (mid == 0 || (mid > 0 && nums[mid - 1] != target)) {
                        return mid;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    if (mid == nums.length - 1 || (mid < nums.length - 1 && nums[mid + 1] != target)) {
                        return mid;
                    } else {
                        left = mid + 1;
                    }
                }
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    
}
