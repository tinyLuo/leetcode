package com.ly.binarysearch;

public class Case154 {

    public static int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            while (hi > lo && nums[hi] == nums[hi - 1])
                hi--;
            int mid = (lo + hi) >> 1;
            if (nums[mid] < nums[hi])
                hi = mid;
            else
                lo = mid + 1;
        }
        return nums[lo];
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        // System.out.println(findMin(arr));
        arr = new int[] { 4, 5, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2 };
        arr = new int[] { 3, 1, 1 };
        System.out.println(findMin(arr));
    }

}
