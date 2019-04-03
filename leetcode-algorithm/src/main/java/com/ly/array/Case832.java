package com.ly.array;

/**
 * 
 * https://leetcode-cn.com/problems/flipping-an-image/
 * @author ly
 *
 */
public class Case832 {
    
    public static int[][] flipAndInvertImage(int[][] A) {
        if(A == null || A.length == 0) {
            return A;
        }
        int[][] B = new int[A.length][A[0].length];
        for(int i = 0 ; i < A.length ; i++) {
            B[i] = revser(A[i]);
        }
        return B;
    }
    
    public static int[] revser(int[] tmp) {
        int[] res = new int[tmp.length];
        int i = 0 , j = tmp.length-1;
        while (i < tmp.length) {
            res[j--] = tmp[i++] == 0 ? 1 : 0;
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[][] A = {{1,1,0},{1,0,1},{0,0,0}};
        flipAndInvertImage(A);
    }
}
