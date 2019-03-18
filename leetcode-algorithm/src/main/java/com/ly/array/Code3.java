package com.ly.array;

import java.util.Arrays;

/**
 * 
 * https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/1/array/23/
 * 
 * @author ly
 *
 */
public class Code3 {

    public static void main(String[] args) {
        Code3 code3 = new Code3();
        int[] nums = { 1, 2, 3, 4, 5, 6 };
        code3.rotate(nums, 2);
        System.out.println(nums.toString());
    }

    // 方法一 一步一步的移动，时间复杂度为 O([k%len]*n)
    // public void rotate(int[] nums, int k) {
    // if(k == 0 || nums == null || nums.length == 0) {
    // return ;
    // }
    // for(int i = 0; i < k ; i++) {
    // rotate1(nums);
    // }
    // }
    //
    // private void rotate1(int[] nums) {
    // int len = nums.length;
    // int step = 0;
    // int idx = 0;
    // int idxValue = nums[idx];
    // int tmp = 0;
    //
    // while(step++ < len) {
    // int replace = calIndex(idx, len, 1);
    // tmp = nums[replace];
    // nums[replace] = idxValue;
    // idx = replace;
    // idxValue = tmp;
    // }
    // }
    //
    // private int calIndex(int idx, int len, int k) {
    // int virtualIdx = idx + k;
    // return virtualIdx % len;
    // }
    // 将数组对称交换，[0,k-1] 对称交换， [k,len-1] 对称交换
    public void rotate(int[] nums, int k) {
        if (k == 0 || nums == null || nums.length == 0 || k % nums.length == 0) {
            return;
        }
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int from, int to) {
        for (; from < to; from++, to--) {
            int tmp = nums[from];
            nums[from] = nums[to];
            nums[to] = tmp;
        }
    }
}
