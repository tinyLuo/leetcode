package com.ly.dynamic;

/**
 * 
 * 区域和检索 - 数组不可变 https://leetcode-cn.com/problems/range-sum-query-immutable/
 * 
 * @author ly
 *
 */
public class Case303 {
    // int[][] dp;
    int[] dp;

    // 内存消耗太多了
    // public Case303(int[] nums) {
    // // dp[i][j] = dp[i][j-1] + nums[j];
    // dp = new int[nums.length][nums.length];
    // for(int i = 0 ; i < nums.length ; i++) {
    // dp[i][i] = nums[i];
    // for(int j = i + 1; j < nums.length ; j++) {
    // dp[i][j] = dp[i][j-1] + nums[j];
    // }
    // }
    // }
    //
    // public int sumRange(int i, int j) {
    // int length = dp.length;
    // if(i > j || i < 0 || i >= length || j >= length) {
    // return -1;
    // }
    // return dp[i][j];
    // }

    public Case303(int[] nums) {
        dp = new int[nums.length];
        if (nums.length > 0) {
            dp[0] = nums[0];
            if (nums.length > 0) {
                for (int i = 1; i < nums.length; i++) {
                    dp[i] = dp[i - 1] + nums[i];
                }
            }
        }
    }

    public int sumRange(int i, int j) {
        int length = dp.length;
        if (i > j || i < 0 || i >= length || j >= length) {
            return -1;
        }
        if (i == 0) {
            return dp[j];
        }
        return dp[j] - dp[i - 1];
    }

    public static void main(String[] args) {
        Case303 case303 = new Case303(new int[] { -2, 0, 3, -5, 2, -1 });
        System.out.println(case303.sumRange(0, 2));
        System.out.println(case303.sumRange(2, 5));
        System.out.println(case303.sumRange(0, 5));
        System.out.println(case303.sumRange(0, 6));
        System.out.println(case303.sumRange(3, 3));
    }

}
