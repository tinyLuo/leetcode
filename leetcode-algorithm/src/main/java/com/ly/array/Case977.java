package com.ly.array;

/**
 * 
 * 有序数组的平方
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 * @author ly
 *
 */
public class Case977 {

    public static int[] sortedSquares(int[] A) {
        int i = 0, j = A.length - 1;
        int[] B = new int[A.length];
        int point = B.length-1;
        while (i <= j) {
            if(Math.abs(A[i]) > Math.abs(A[j])) {
                B[point] = A[i] * A[i];
                i++;
            }else {
                B[point] = A[j] * A[j];
                j--;
            }
            point--;
        }
        return B;
    }
    
    public static void main(String[] args) {
        int[] A = {-7,-3,2,3,11};
        int[] B = sortedSquares(A);
        for(int i : B) {
            System.out.println(i);
        }
    }
    
}
