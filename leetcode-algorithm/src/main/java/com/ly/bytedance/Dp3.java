package com.ly.bytedance;

/**
 * 
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * 
 * @author ly
 *
 */
public class Dp3 {
    public int maximalSquare(char[][] matrix) {
        //如果点M(x,y)是边长为 a 的正方形，那么点 J(x-1,y),K(x,y-1),L(x-1,y-1)一定都是边长为 a-1 的正方形
        //得到状态状态转移方程： 如果点(x,y)=1,到点 (x,y) 最长的正方形的边为 f(x,y),f(x,y) = min(f(x-1,y),f(x,y-1),f(x-1,y-1)) + 1
        int square = 0;
        if (matrix == null || matrix.length == 0) {
            return square;
        }
        int maxLen = 0;
        int xlen = matrix.length;
        int ylen = matrix[0].length;
        int[][] dp = new int[xlen][ylen];
        for(int i = 0 ; i < xlen ; i++) {
            for(int j = 0 ; j < ylen ; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] - '0';
                }else {
                    if(matrix[i][j] == '1') {
                        dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1],dp[i-1][j-1])) + 1;
                    }
                }
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }
        return maxLen * maxLen;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[4][2];
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
    }
}
