package com.ly.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Case54 {
    
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0) {
            return res;
        }
        //0 初始，1 向右 2 向下 3 向左 4 向上 1->2->3->4->1 状态转移
        int direct = 0;
        int row = 0;
        int column = 0;
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> columnSet = new HashSet<>();
        int len = matrix.length * matrix[0].length;
        for(int i = 0 ; i < len ; i++) {
            res.add(matrix[row][column]);
            if(matrix.length == 1) {
                column++;
                continue;
            }
            if(matrix[0].length == 1) {
                row++;
                continue;
            }
            if(direct == 0) {
                column++;
                direct = 1;
            }else if (direct == 1) {
                if(!columnSet.contains(column+1) && column < matrix[0].length-1) {
                    column++;
                }else {
                    rowSet.add(row);
                    row++;
                    direct = 2;
                }
            }else if (direct == 2) {
                if(!rowSet.contains(row+1) && row < matrix.length - 1) {
                    row++;
                }else {
                    columnSet.add(column);
                    column--;
                    direct = 3;
                }
            }else if (direct == 3) {
                if(!columnSet.contains(column-1) && column > 0) {
                    column--;
                }else {
                    rowSet.add(row);
                    row--;
                    direct = 4;
                }
            }else {
                if(!rowSet.contains(row-1) && row > 0) {
                    row--;
                }else {
                    columnSet.add(column);
                    column++;
                    direct = 1;
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        spiralOrder(new int[][] {{1, 2, 3},{4,5,6},{7,8,9}});
    }
}
