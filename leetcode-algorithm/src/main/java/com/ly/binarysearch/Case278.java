package com.ly.binarysearch;

public class Case278 {
    public static int firstBadVersion(int n) {
        if(n == 0) {
            return 0;
        }
        int left = 1;
        int right = n;
        int bad = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean isBadVersion = isBadVersion(mid);
            if(isBadVersion) {
                right = mid - 1;
                bad = Math.min(bad, mid);
            }else {
                left = mid + 1;
            }
        }
        if(isBadVersion(bad)) {
            return bad;
        }
        return -1;
    }
    
    
    static boolean isBadVersion(int version) {
        if(version == 2147483647) {
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        firstBadVersion(2147483647);
    }
}
