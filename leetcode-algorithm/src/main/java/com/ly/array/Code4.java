package com.ly.array;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/1/array/24/
 * @author luoyao
 *
 */
public class Code4 {
	
//	public boolean containsDuplicate(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        for(Integer num : nums) {
//        		if(set.contains(num)) {
//        			return true;
//        		}
//        		set.add(num);
//        }
//        return false;
//	}
	
	public static void main(String[] args) {
		Code4 code4 = new Code4();
		int[] nums = {3,1,3,6};
		System.out.println(code4.containsDuplicate(nums));
	}
	
	public boolean containsDuplicate(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    break;
                } else if (nums[i] == nums[j]) {
                    return true;
                }
            }

        }
        return false;
	}
	
}
