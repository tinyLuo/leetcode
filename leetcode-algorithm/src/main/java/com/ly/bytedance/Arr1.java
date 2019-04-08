package com.ly.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1020/
 * 三数之和
 * @author ly
 *
 */
public class Arr1 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums == null || nums.length < 4) {
            return list;
        }
        Arrays.sort(nums);
        for(int i = 0;i < nums.length-2;i++) {
            for(int j = i + 1; j < nums.length - 1; j++) {
                for(int k = j+1; k < nums.length; k++) {
                    
                }
            }
        }
        return list;
    }
    
    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums == null || nums.length < 3) {
            return list;
        }
        Arrays.sort(nums);
        
        for(int i = 0 ; i < nums.length - 2 ; i++) {
            //最小的大于0，跳出循环 
            if (nums[i] > 0) {
                break;
            }
            //去掉重复的
            if(i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            //左右指针
            int l = i+1,r = nums.length-1;
            int lrSum = 0 - nums[i];
            //从右往做扫
            while (l < r) {
                if(nums[l] + nums[r] == lrSum) {
                    list.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    //左指针向右移，右指针向左移，并去重
                    while (l < nums.length-1 && nums[l] == nums[++l]) {
                        
                    }
                    while (r > 0 && nums[r] == nums[--r]) {
                        
                    }
                }else if (nums[l] + nums[r] > lrSum) {
                    //右指针向左移，并去重
                    while (r > 0 && nums[r] == nums[--r]) {
                        
                    }
                }else {
                    //做指针右移，并去重
                    while (l < nums.length-1 && nums[l] == nums[++l]) {
                        
                    }
                }
            }
        }
        return list;
    }
    
    public static void main(String[] args) {
        System.out.println(threeSum1(new int[] {3,0,-2,-1,1,2}));
    }
    
}
