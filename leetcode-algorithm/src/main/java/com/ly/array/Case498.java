package com.ly.array;

public class Case498 {
    
    public static int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null) {
            return null;
        }
        if(matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int[] result = new int[matrix.length * matrix[0].length];
        //0起始 1:向右 2左下 3下 4右上 
        int preDirect = 0;
        int row = 0;
        int column = 0;
        
        for(int i=0; i < result.length; i++) {
            result[i] = matrix[row][column];
            if(matrix.length == 1) {
                column++;
                continue;
            }
            if(matrix[0].length == 1) {
                row++;
                continue;
            }
            if(preDirect == 0) {
                if(matrix[0].length > 1) {
                    column++;
                    preDirect = 1;
                }else {
                    row++;
                    preDirect = 3;
                }
            }else if (preDirect == 1) {
                if(row == 0) {
                    row++;
                    column--;
                    preDirect = 2;
                }else {
                    row--;
                    column++;
                    preDirect = 4;
                }
            }else if (preDirect == 2) {
                if(row < matrix.length - 1 && column > 0) {
                    row++;
                    column--;
                    preDirect = 2;
                }else if (row == matrix.length - 1) {
                    column++;
                    preDirect = 1;
                }else if (column == 0) {
                    row++;
                    preDirect = 3;
                }
            }else if (preDirect == 3) {
                if(column == 0) {
                    row--;
                    column++;
                    preDirect = 4;
                }else {
                    row++;
                    column--;
                    preDirect = 2;
                }
            }else {
                if(row > 0 && column < matrix[0].length - 1) {
                    row--;
                    column++;
                    preDirect = 4;
                }else if (column == matrix[0].length - 1) {
                    row++;
                    preDirect = 3;
                }else {
                    column++;
                    preDirect = 1;
                }
                
            }
        }
        return result;
    }
    
    
    public static void main(String[] args) {
        
        int[][] a = new int[][] {{6,9,7}};
        findDiagonalOrder(a);
    }
}
