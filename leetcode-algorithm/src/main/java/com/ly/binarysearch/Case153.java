package com.ly.binarysearch;

public class Case153 {
    public static int findMin(int[] nums) {
        int start = 0;
        int mid = 0;
        int end = nums.length - 1;
        while (start <= end) {
            mid = (start + end) / 2;
            if ((mid >= 1 && nums[mid] < nums[mid - 1]) || (mid == 0 && nums[mid] < nums[nums.length - 1]))
                return nums[mid];
            if (nums[end] < nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return nums[start];
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(findMin(nums));
    }
}
