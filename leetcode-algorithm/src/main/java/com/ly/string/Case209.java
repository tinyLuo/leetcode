package com.ly.string;

public class Case209 {

    public static int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        while (left < nums.length && right < nums.length) {
            if (nums[right] == s) {
                return 1;
            } else {
                sum += nums[right];
                if (sum == s) {
                    minLen = Math.min(minLen, right - left + 1);
                    sum -= nums[left];
                    left++;
                    right++;
                } else if (sum > s) {
                    sum -= nums[left];
                    sum -= nums[right];
                    left++;
                } else {
                    right++;
                }
            }
        }
        if(minLen == Integer.MAX_VALUE) {
            return 0;
        }
        return minLen;
    }
    
    public static int op(int s, int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int  res = 0, sum = 0;
        for(int i=0, j=0; j < nums.length; j++){
            sum += nums[j];
            if(sum >= s){
                res = res < j - i + 1 && res != 0 ? res : j - i + 1;
                sum -= nums[i];
                sum -= nums[j];
                i++;
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(op(11, new int[] { 1,2,3,4,5 }));
    }

}
