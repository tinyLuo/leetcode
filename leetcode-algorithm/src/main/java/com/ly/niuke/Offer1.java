package com.ly.niuke;

public class Offer1 {
    
    public boolean Find(int target, int [][] array) {
        if(array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        //只能从左下角或者右上角开始
        int r = 0, c = array[0].length - 1;
        while (r < array.length && c >= 0) {
            if(array[r][c] == target) {
                return true;
            }else if (array[r][c] > target) {
                c--;
            }else {
                r++;
            }
        }
        return false;
    }
    
}
