package com.ly.string;

public class Case27 {

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        removeElement(new int[] { 3, 2, 2, 3 }, 3);
    }

}
