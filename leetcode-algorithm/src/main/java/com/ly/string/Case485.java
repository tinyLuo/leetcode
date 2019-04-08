package com.ly.string;

public class Case485 {
    
    public static int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int pre = -1;
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                if(pre == -1) {
                    pre = i;
                    max = pre;
                }else {
                    max = Math.max(i - pre - 1,max);
                    pre = i;
                }
            }
        }
        if(pre != nums.length - 1) {
            max = Math.max(max, nums.length-pre-1);
        }
        return max;
    }
    
    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[] {0,1,1,0,0,0,1,1,1,1}));
    }
    
}
