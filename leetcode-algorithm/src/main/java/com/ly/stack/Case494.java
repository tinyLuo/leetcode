package com.ly.stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Case494 {

    public static Set<String> opSet;
    
    public static int res = 0;
    
    static {
        opSet = new HashSet<>();
        opSet.add("+");
        opSet.add("-");
    }
    
    public static int findTargetSumWays(int[] nums, int S) {
        if(nums == null || nums.length > 1000) {
            return 0;
        }
        int len = nums.length;
        //+
        dfs("+", nums, 1, nums[0], len, S);
        dfs("-", nums, 1, nums[0], len, S);
        
        //-
        dfs("+", nums, 1, -nums[0], len, S);
        dfs("-", nums, 1, -nums[0], len, S);
        return res / 2;
    }
    
    
    public static void dfs(String op, int[] nums ,int depth, int lastSum, int maxLen, int target) {
        if(depth == maxLen) {
            if(lastSum == target) {
                res++;
            }
            return;
        }
        
        if(op == "+") {
            lastSum += nums[depth];
        }else {
            lastSum -= nums[depth];
        }
        dfs("+", nums, depth+1, lastSum, maxLen, target);
        dfs("-", nums, depth+1, lastSum, maxLen, target);
    }
    
    public static void main(String[] args) {
        int[] nums = new int[] {1, 1, 1, 1, 1};
        System.out.println(findTargetSumWays(nums, 3));
    }
}
