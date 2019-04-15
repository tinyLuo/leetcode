package com.ly.binarysearch;

public class Case162 {
    
    public static int findPeakElement(int[] nums) {
        //根据波峰的性质，往高处搜索肯定能搜索一个一个波峰，或者单调递增的最高点（非波峰）
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(mid > 0 && nums[mid - 1] > nums[mid]) {
                right = mid - 1;
            }else if (mid < nums.length - 1 && nums[mid+1] > nums[mid]) {
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] nums = new int[] {0};
        findPeakElement(nums);
    }
    
}
