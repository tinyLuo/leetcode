package com.ly.string;

public class Case283 {

    public static void moveZeroes(int[] nums) {
        
        if(nums == null || nums.length == 0) {
            return ;
        }
        int firstZero = nums.length - 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            //将 i 移到 firstZero 的位置
            if(nums[i] == 0) {
                for(int j = i+1; j <= firstZero ; j++) {
                    nums[j-1] = nums[j];
                }
                nums[firstZero] = 0;
                firstZero--;
            }
        }
        System.out.println(nums);
    }
    
    public static void main(String[] args) {
        moveZeroes(new int[] {0});
        moveZeroes(new int[] {1,1,0,1,22,0,0,1,0});
    }
}
