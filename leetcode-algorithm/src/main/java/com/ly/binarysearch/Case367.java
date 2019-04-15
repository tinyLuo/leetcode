package com.ly.binarysearch;

import javax.sound.midi.MidiChannel;

public class Case367 {
    
    public static boolean isPerfectSquare(int num) {
        if(num == 0) {
            return true;
        }
        int left = 1;
        int right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int x = num / mid;
            int y = num % mid;
            if(x == mid && y == 0) {
                return true;
            }else if (x == mid) {
                return false;
            }else if (x > mid) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(1));
        System.out.println(isPerfectSquare(2));
        System.out.println(isPerfectSquare(3));
        System.out.println(isPerfectSquare(4));
        System.out.println(isPerfectSquare(5));
        System.out.println(isPerfectSquare(6));
        System.out.println(isPerfectSquare(7));
        System.out.println(isPerfectSquare(8));
        System.out.println(isPerfectSquare(9));
    }
    
}
