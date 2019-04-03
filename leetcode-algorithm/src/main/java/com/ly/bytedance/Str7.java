package com.ly.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1044/
 * 复原IP地址
 * @author ly
 *
 */
public class Str7 {
    
    //通用的情况
    public static List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        //ip 地址的定义：每位 0-255
        if(s == null || (s = s.trim()).length() < 4) {
            return list;
        }
        
        int len = s.length();
        for(int i = 1 ; i < 4 ; i++) {
            String one = s.substring(0, i);
            int num = parserNum(one);
            if(!isIlleg(num, len - i, 1)) {
                continue;
            }
            for(int j = i+1 ; j < len  && j < i+4 ; j++) {
                String two = s.substring(i, j);
                int twoNum = parserNum(two);
                if(!isIlleg(twoNum, len - j, 2)) {
                    continue;
                }
                for(int k = j+1 ; k < len && k < j + 4 ;k++) {
                    String three = s.substring(j, k);
                    int threeNum = parserNum(three);
                    if(!isIlleg(threeNum, len - k, 3)) {
                        continue;
                    }
                    String four = s.substring(k, s.length());
                    int fourNum = parserNum(four);
                    if(!isIlleg(fourNum, 0, 4)) {
                        continue;
                    }
                    list.add(num+"."+twoNum+"."+threeNum+"."+fourNum);
                }
            }
        }
        return list;
    }
    
    public static List<String> restoreIpAddresses2(String s) {
        List<String> list = new ArrayList<>();
        //ip 地址的定义：每位 0-255
        if(s == null || (s = s.trim()).length() < 4) {
            return list;
        }
        
        int len = s.length();
        for(int i = 1 ; i < 4 ; i++) {
            String one = s.substring(0, i);
            if(!isIlleg(one, len - i, 1)) {
                continue;
            }
            for(int j = i+1 ; j < len  && j < i+4 ; j++) {
                String two = s.substring(i, j);
                if(!isIlleg(two, len - j, 2)) {
                    continue;
                }
                for(int k = j+1 ; k < len && k < j + 4 ;k++) {
                    String three = s.substring(j, k);
                    if(!isIlleg(three, len - k, 3)) {
                        continue;
                    }
                    String four = s.substring(k, s.length());
                    if(!isIlleg(four, 0, 4)) {
                        continue;
                    }
                    list.add(one+"."+two+"."+three+"."+four);
                }
            }
        }
        return list;
    }
    
    
    public static boolean isIlleg(String num, int len, int bit) {
        if(len < 4 - bit || len > 3 * (4-bit)) {
            return false;
        }
        
        if(num.startsWith("00")) {
            return false;
        }
        
        int n = Integer.valueOf(num);
        
        if(n > 255) {
            return false;
        }
        return true;
    }
    
    public static boolean isIlleg(int num, int len, int bit) {
        if(len < 4 - bit || len > 3 * (4-bit)) {
            return false;
        }
        if(num > 255) {
            return false;
        }
        return true;
    }
    
    public static int parserNum(String s) {
        while (s.length() > 1 && s.startsWith("0")) {
            s = s.substring(1);
        }
        return Integer.valueOf(s);
    }
    
    public static void main(String[] args) {
        System.out.println(restoreIpAddresses2("000010"));
        System.out.println(restoreIpAddresses2("0000"));
        
        System.out.println(restoreIpAddresses2("010010"));
    }
}
