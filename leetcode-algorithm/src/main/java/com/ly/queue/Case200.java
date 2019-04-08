package com.ly.queue;

/**
 * https://leetcode-cn.com/problems/number-of-islands/
 * 岛屿的个数
 * @author didi
 *
 */
public class Case200 {

    public static int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int sum = 0;
        for(int i = 0 ; i < grid.length ; i++) {
            
            for(int j = 0 ; j < grid[i].length ; j++) {
                if(grid[i][j] == '1') {
                    bfs(i, j, grid);
                    sum ++;
                }
            }
        }
        return sum;
    }
    
    //从点 (i,j) 开始找到所有连接的点 
    private static void bfs(int i, int j , char[][] grid) {
        grid[i][j] = '0'; 
        //上下左右四个方向
        if(i > 0 && grid[i-1][j] == '1') {
            bfs(i-1, j, grid);
        }
        if(i < grid.length - 1 && grid[i+1][j] == '1') {
            bfs(i+1, j, grid);
        }
        if(j > 0 && grid[i][j-1] == '1') {
            bfs(i, j-1, grid);
        }
        if(j < grid[i].length - 1 && grid[i][j+1] == '1') {
            bfs(i, j+1, grid);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{{'1','1','1'},{'0','1','0'},{'1','1','1'}}));
    }
}
