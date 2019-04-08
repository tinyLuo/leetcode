package com.ly.string;

public class Case167 {

    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length == 0) {
            return new int[0];
        }
        int[] res = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum == target) {
                res[0] = left;
                res[1] = right;
                break;
            }else if(sum > target){
                right--;
            }else {
                left++;
            }
        }
        return res;
    }
}
