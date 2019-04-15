package com.ly.binarysearch;

public class Case69 {
    
    public static int mySqrt(int x) {
        if(x == 0) {
            return 0;
        }
        int left = 1;
        int right = x;
        int idx = -1;
        int cz = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int d = x / mid;
            if(d == mid) {
                return mid;
            }else if (d < mid) {
                right = mid - 1;
            }else {
                left = mid + 1;
                if(idx == -1) {
                    idx = mid;
                    cz = d - mid ;
                }else {
                    if(cz > d - mid) {
                        cz = d - mid;
                        idx = mid;
                    }
                }
            }
        }
        return idx;
    }
    
    public static void main(String[] args) {
        System.out.println(mySqrt(0));
        System.out.println(mySqrt(1));
        System.out.println(mySqrt(2));
        System.out.println(mySqrt(3));
        System.out.println(mySqrt(10));
        System.out.println(mySqrt(100));
        System.out.println(mySqrt(2147395599));
    }
    
}
