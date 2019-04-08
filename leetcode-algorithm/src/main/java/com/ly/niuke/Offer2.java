package com.ly.niuke;


public class Offer2 {
    
    public static String replaceSpace(StringBuffer str) {
        if(str == null | str.length() == 0) {
            return "";
        }
        StringBuilder b1 = new StringBuilder();
        StringBuilder b2 = new StringBuilder();
        int left = 0;
        int len = str.length();
        int mid = len / 2;
        int right = mid;
        while (left < mid) {
            char lc = str.charAt(left++);
            char rc = str.charAt(right++);
            if(lc == ' ') {
                b1.append("%20");
            }else {
                b1.append(lc);
            }
            if(rc == ' ') {
                b2.append("%20");
            }else {
                b2.append(rc);
            }
        }
        if(len % 2 == 1) {
            char rc = str.charAt(right);
            if(rc == ' ') {
                b2.append("%20");
            }else {
                b2.append(rc);
            }
        }
        return b1.toString() + b2.toString();
    }
    
    public static void main(String[] args) {
        StringBuffer builder = new StringBuffer("We Are Happy.");
        System.out.println(replaceSpace(builder));
    }
    
}
