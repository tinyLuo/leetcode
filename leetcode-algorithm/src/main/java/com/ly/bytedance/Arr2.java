package com.ly.bytedance;

/**
 * 
 * https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1034/
 * 岛屿的最大面积
 * @author ly
 *
 */
public class Arr2 {

    public static int maxAreaOfIsland1(int[][] grid) {
        // dp[x][y] = dp[x-1][y] + dp[x][y-1] + 1
        if (grid == null) {
            return 0;
        }
        int[][] dp = new int[grid.length+1][grid[0].length+1];
        int max = 0;
        for(int i = 1; i < dp.length ; i++) {
            for(int j = 1 ; j < dp[i].length ; j++) {
                if(grid[i-1][j-1] == 1) {
                    //1.左上对角都是1
                    if(dp[i-1][j] > 0 && dp[i][j-1] > 0 && dp[i-1][j-1] > 0) {
                        dp[i][j] = dp[i][j-1] + 1;
                    }else if ((dp[i][j-1] == 0 || dp[i-1][j-1] == 0) && dp[i-1][j] > 0) {
                        //左上角为0
                        int k = j + 1;
                        while (k < dp[i].length && dp[i-1][k] > 0) {
                            k++;
                            if(k >= dp[i].length) {
                                break;
                            }
                        }
                        dp[i][j] = dp[i][j-1] + dp[i-1][--k] + 1;
                    }else {
                        dp[i][j] = dp[i-1][j] + dp[i][j-1] +1;
                    }
                    max = Math.max(max, dp[i][j]);
                    System.out.println(max);
                }
            }
        }
        return max;
    }
    
    public static int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length < 1 || grid[0] == null || grid[0].length < 1){
            return 0;
        }
        int maxArea = 0;
        for(int i=0; i < grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                int area = getArea( grid, i, j);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
    private static int getArea(int[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1){
            return 0;
        }
        int area = 1;
        // 表示访问过了
        grid[i][j] = 2;
        area += getArea(grid,i + 1, j);
        area += getArea(grid,i - 1, j);
        area += getArea(grid,i, j + 1);
        area += getArea(grid,i, j - 1);
        return area;
    }
    
    
    public static void main(String[] args) {
        //int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},
        //        {0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        //int[][] grid = {{1,1},{1,0}};
        int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        System.out.println(maxAreaOfIsland(grid));
    }
}
