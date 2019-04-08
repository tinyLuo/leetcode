package com.ly.string;

public class Case344 {
    
    public static  void reverseString(char[] s) {
        if(s == null || s.length <= 1) {
            return ;
        }
        
        char tmp = s[0];
        int left = 0;
        int right = s.length-1;
        while (left < right) {
            tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
    
    
    public static void main(String[] args) {
        reverseString(new char[] {'a','b','c'});
        reverseString(new char[] {'a','b','c','d'});
    }
    
}
