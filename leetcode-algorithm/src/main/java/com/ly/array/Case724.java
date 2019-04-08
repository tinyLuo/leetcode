package com.ly.array;

import java.util.HashMap;
import java.util.Map;


public class Case724 {
    
    public static int pivotIndex(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();
        int maxRight = 0;
        for(int i = 1 ; i < nums.length; i++) {
            maxRight += nums[i]; 
        }
        if(maxRight == 0) {
            return 0;
        }
        rightMap.put(0, maxRight);
        rightMap.put(nums.length - 1, 0);
        leftMap.put(0, 0);
        for(int i = 1 ; i < nums.length - 1; i++) {
            int cur = nums[i];
            int left = nums[i-1] + leftMap.getOrDefault(i-1, 0);
            int right = rightMap.get(i-1) - cur;
            if(left == right) {
                return i;
            }
            leftMap.put(i, left);
            rightMap.put(i, right);
        }
        if(leftMap.get(nums.length - 2) + nums[nums.length - 2] == 0) {
            return nums.length - 1;
        }
        return -1;
    }
    
    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[] {1, 7, 3, 6, 5, 6}));
        System.out.println(pivotIndex(new int[] {1, 2, 3}));
        System.out.println(pivotIndex(new int[] {-1,-1,-1,0,1,1}));
        System.out.println(pivotIndex(new int[] {2,-1,-2,0,1,1}));
    }
    
}
