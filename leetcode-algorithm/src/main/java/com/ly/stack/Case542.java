package com.ly.stack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Case542 {
    private static int row;
    private static int col;

    public static int min = Integer.MAX_VALUE;
    
    public static int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        // 第一次遍历，正向遍历，根据相邻左元素和上元素得出当前元素的对应结果
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = row + col;
                }
                if (i > 0) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i - 1][j] + 1);
                }
                if (j > 0) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][j - 1] + 1);
                }
            }
        }
        // 第二次遍历，反向遍历，根据相邻右元素和下元素及当前元素的结果得出最终结果
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (i < row - 1) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i + 1][j] + 1);
                }
                if (j < col - 1) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][j + 1] + 1);
                }
            }
        }
        return matrix;
    }
    
    public static void minDis(int[][] matrix, int i, int j, int curDis,Map<Integer, Set<Integer>> map) {
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[i].length) {
            return ;
        }
        if(matrix[i][j] == 0) {
            min = Math.min(curDis, min);
            return;
        }
        if(map.containsKey(i)) {
            if(map.get(i).contains(j)) {
                return ;
            }
        }
        Set<Integer> set = map.getOrDefault(i, new HashSet<>());
        set.add(j);
        map.put(i, set);
        minDis(matrix, i+1, j, curDis + 1,map);
        minDis(matrix, i-1, j, curDis + 1,map);
        minDis(matrix, i, j+1, curDis + 1,map);
        minDis(matrix, i, j-1, curDis + 1,map);
    }
    
    public static void main(String[] args) {
        int[][] matrix = new int[][] {{0,0,0},{0,1,0},{1,1,1}};
        
        updateMatrix(matrix);
    }
    
}
