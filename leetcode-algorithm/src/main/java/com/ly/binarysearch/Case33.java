package com.ly.binarysearch;

public class Case33 {
    
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
            }
            //[left,right] 单调递增
            if(mv >= nums[left] && mv <= nums[right]) {
                if(mv > target) {
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else if (mv >= nums[left] && mv >= nums[right]) {
                //mid处于左单调递增区间
                if(mv > target) {
                    if(target >= nums[left]) {
                        right = mid - 1;
                    }else {
                        left = mid + 1;
                    }
                }else {
                    left = mid + 1;
                    right--;
                }
            }else {
                //mid处于左单调递增区间
                if(mv > target) {
                    right = mid - 1;
                    left++;
                }else {
                    if(target >= nums[left]) {
                        right = mid - 1;
                    }else {
                        left = mid + 1;
                    }
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] nums = new int[] {4,5,6,7,0,1,2};
        search(nums, 0);
    }
    
}
