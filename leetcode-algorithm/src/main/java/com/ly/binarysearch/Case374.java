package com.ly.binarysearch;

public class Case374 {
    
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int guess = guess(mid);
            if(guess == 0) {
                return mid;
            }else if (guess == -1) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }
 
    public int guess(int num) {
        return 0;
    }
}
