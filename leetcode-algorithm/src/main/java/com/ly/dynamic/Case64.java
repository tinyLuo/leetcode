package com.ly.dynamic;

/**
 * 
 * 最小路径和
 * https://leetcode-cn.com/problems/minimum-path-sum/
 * @author ly
 *
 */
public class Case64 {
    
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            int[] row = grid[i];
            for(int j = 0; j < row.length; j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = row[j];
                }else if(i == 0){
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                }else if (j == 0) {
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                }else {
                    dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + grid[i][j];
                }
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
    
}
