package com.ly.dynamic;

/**
 * 
 * 等差数列划分
 * https://leetcode-cn.com/problems/arithmetic-slices/
 * @author ly
 *
 */
public class Case413 {
    
    public static int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length < 3) {
            return 0;
        }
        int result = 0;
        for(int i = 0 ; i < A.length - 2 ; i++) {
            for(int j = i+2 ; j < A.length ; j++) {
                if(A[j] - A[j-1] == A[j-1] - A[j-2]) {
                    result++;
                }else {
                    break;
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] a = {1,2,3,8,9,10};
        System.out.println(numberOfArithmeticSlices(a));
    }
    
}
