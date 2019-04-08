package com.ly.array;

public class Case66 {
    
    public static int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) {
            return digits;
        }
        int jw = 1;
        for(int i = digits.length -1 ; i >= 0 ;i--) {
            int cur = digits[i] + jw;
            if(cur == 10) {
                jw = 1;
                digits[i] = 0;
            }else {
                jw = 0;
                digits[i] = cur;
            }
        }
        
        if(jw == 1) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            for(int i = 0; i<digits.length ; i++) {
                newDigits[i+1] = digits[i];
            }
            digits = newDigits;
        }
        return digits;
    }
    
    
    public static void main(String[] args) {
        System.out.println(plusOne(new int[] {4,3,2,1}));
        System.out.println(plusOne(new int[] {9,9,9,9}));
        System.out.println(plusOne(new int[] {9,9,9,9,9,9,9,9,9,9,9,9,9,9,9}));
    }
}
