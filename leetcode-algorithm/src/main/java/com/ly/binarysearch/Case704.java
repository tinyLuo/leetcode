package com.ly.binarysearch;

public class Case704 {
    
    public static int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int mv = nums[mid];
            if(mv == target) {
                return mid;
            }else if (mv > target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        
        int[] nums = new int[] {5};
        search(nums, 5);
    }
    
}
