package com.ly.binarysearch;


public class Case50 {
    
    public static double myPow(double x, int n) {
        double res = 1.0;
        for(int i = n ; i != 0 ; i = i / 2) {
            if(i % 2 != 0) {
                res *= x;
            }
            x *= x;
        }
        return n > 0 ? res : 1 / res;
    }
    
    public static void main(String[] args) {
        myPow(2.0, 11);
    }
    
}
