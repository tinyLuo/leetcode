package com.ly.array;

/**
 * 
 * https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/1/array/21/
 * 
 * @author ly
 *
 */
public class Code1 {
    
    public static void main(String[] args) {
        Code1 code1 = new Code1();
        int[] nums = {1,1,1,2,2,2,3,3,3,4};
        System.out.println(code1.removeDuplicates(nums));
    }
    
    public int removeDuplicates(int[] nums) {
        //边界条件
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int index = 0;
        for(int i = 0 ; i < nums.length -1 ; i++) {
            // 记录最后一条不重复的数
            if(nums[i] != nums[i+1]) {
                nums[index++] = nums[i];
            }
        }
        nums[index++] = nums[nums.length-1];
        return index;
    }
}
