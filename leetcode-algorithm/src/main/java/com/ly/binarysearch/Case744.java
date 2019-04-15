package com.ly.binarysearch;

public class Case744 {
    
    public static char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            char mc = letters[mid];
            if(target >= mc){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
            if(left > right) {
                break;
            }
        }
        //left 的位置就是比目标字母大的第一个数
        if(left == letters.length) {
            return letters[0];
        }else {
            return letters[left];
        }
    }
    
    public static void main(String[] args) {
        char[] letters = new char[] {'e','e','e','e','e','e','n','n','n','n'};
        System.out.println(nextGreatestLetter(letters, 'n'));
    }
    
}
