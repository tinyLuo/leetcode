package com.ly.bytedance;

/**
 * 
 * 字符串的排列
 * https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1016/
 * @author ly
 *
 */
public class Str3 {
    
    
    //超时了
    public static boolean checkInclusion(String s1, String s2) {
        if(!check(s1) || !check(s2) || s1.length() > s2.length()){
            return false;
        }
        int s1Len = s1.length();
        int s2Len = s2.length();
        for(int i = 0; i < s2Len - s1Len + 1; ) {
            String subS2 = s2.substring(i, i+s1Len);
            boolean inClusion = true;
            int skipIndex = Integer.MAX_VALUE;
            for(int j = 0 ; j < s1Len ; j++) {
                int index = subS2.indexOf(s1.substring(j, j+1));
                if(index == -1) {
                    inClusion = false;
                    continue;
                }
                skipIndex = Math.min(skipIndex, index);
                subS2 = subS2.substring(0,index) + subS2.substring(index+1,subS2.length());
            }
            if(inClusion) {
                return true;
            }
            if(skipIndex == Integer.MAX_VALUE) {
                skipIndex = s1Len;
            }
            if(skipIndex == 0) {
                skipIndex = 1;
            }
            i += skipIndex;
        }
        return false;
    }

    public static boolean checkInclusion1(String s1, String s2) {
        if(!check(s1) || !check(s2) || s1.length() > s2.length()){
            return false;
        }
        // 映射表 m[i] > 0 代表 S1 中 i 出现的次数，m[i] < 0 代表 S2 中 i 出现的次数， m[i] = 0 说明 i 在 S1 和 S2 中都出现了
        int[] m = new int[26];
        
        //记录 s1 中每个字符出现的次数 
        for(char c : s1.toCharArray()) {
            m[c-'a']++;
        }
        int s1Len = s1.length();
        int s2Len = s2.length();
        int count = s1Len;
        int right = 0, left = 0;
        for(right = 0 ; right < s2Len; right++) {
            //判断 S2 当前位置是否在 S1 中出现
            if(m[s2.charAt(right)-'a'] > 0) {
                count--;
            }
            m[s2.charAt(right)-'a']--;
            if(count == 0) {
                return true;
            }
            if(right - left + 1 == s1Len) {
                //left 向右移一位
                if(++m[s2.charAt(left) - 'a'] > 0) {
                    count++;
                }
                left++;
            }
        }
        return false;
    }
    public static boolean check(String s) {
        if(s == null || s.length() == 0) {
            return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        //System.out.println(checkInclusion1("ab", "eidbaooo"));
        //System.out.println(checkInclusion1("hello", "ooolleoooleh"));
        System.out.println(checkInclusion1("ab", "cba"));
        //System.out.println(checkInclusion1("ab", "abc"));
    }
}
