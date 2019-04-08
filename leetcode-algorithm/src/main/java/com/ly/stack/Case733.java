package com.ly.stack;

public class Case733 {
    
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[0].length == 0) {
            return image;
        }
        int old = image[sr][sc];
        dfs(image, sr, sc, old, newColor);
        return image;
    }
    
    public static void dfs(int[][] image, int r, int c, int old, int newColor) {
        if(r < 0 || r >= image.length || c < 0 || c >= image[r].length || image[r][c] == newColor) {
            return;
        }
        if(image[r][c] != old) {
            return;
        }
        image[r][c] = newColor;
        dfs(image, r+1, c, old, newColor);
        dfs(image, r-1, c, old, newColor);
        dfs(image, r, c+1, old, newColor);
        dfs(image, r, c-1, old, newColor);
    }
    
    public static void main(String[] args) {
        int[][] image = new int[][] {{0,0,0},{0,0,0}};
        floodFill(image, 0, 0, 2);
    }
    
}
