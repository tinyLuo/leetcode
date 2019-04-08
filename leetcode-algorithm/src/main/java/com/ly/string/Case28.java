package com.ly.string;

import java.util.zip.ZipEntry;

public class Case28 {
    
    public static int strStr(String haystack, String needle) {
        if(haystack == null || haystack.length() == 0 || needle == null || needle.length() > haystack.length()) {
            return -1;
        }
        if(needle.length() == 0) {
            return 0;
        }
        for(int i = 0 ; i < haystack.length() - needle.length() + 1 ;i++) {
            boolean isp = true;
            for(int j = 0 ; j < needle.length() ;j++) {
                if(haystack.charAt(i+j) != needle.charAt(j)) {
                    isp = false;
                    break;
                }
            }
            if(isp) {
                return i;
            }
            
        }
        return -1;
    }
    
    public static int kmp(String haystack, String needle) {
        if(haystack == null || haystack.length() == 0 || needle == null || needle.length() > haystack.length()) {
            return -1;
        }
        if(needle.length() == 0) {
            return 0;
        }
        
        int[] next = getNext(needle.toCharArray());
        
        int i = 0,j = 0;
        while (i != haystack.length()) {
            while (j != -1 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j];
            }
            ++i; ++j;
            if(j == needle.length()) {
                return i - j;
            }
        }
        return -1;
    }
    
    public static int[] getNext(char[] t) {
        int[] next = new int[t.length];
        next[0] = -1;
        if(t.length < 2) {
            return next;
        }
        next[1] = 0;
        int k;
        for (int j = 2; j < t.length; j++) {
            k=next[j-1];
            while (k!=-1) {
                if (t[j - 1] == t[k]) {
                    next[j] = k + 1;
                    break;
                } else {
                    k = next[k];
                }
                next[j] = 0;  //当k==-1而跳出循环时，next[j] = 0，否则next[j]会在break之前被赋值
            }
        }
        return next;
    }
    
    public static void main(String[] args) {
        System.out.println(kmp("hello", "ll"));
    }
    
}
