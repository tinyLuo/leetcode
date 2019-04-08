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
        if(A==null || A.length==0) {
            return A;
        }
        int[] B = new int[A.length];
        int l = 0 , r = A.length -1 , point = A.length - 1;
        while(l <= r) {
            if(A[l] >= 0) {
                B[point--] = A[r] * A[r];
                r--;
            }else {
                if(A[l] + A[r] >= 0) {
                    B[point--] = A[r] * A[r];
                    r--;
                }else {
                    B[point--] = A[l] * A[l];
                    l++;
                }
            }
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
