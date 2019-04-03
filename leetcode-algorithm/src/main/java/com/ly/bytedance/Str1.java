package com.ly.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 无重复字符的最长子串
 * https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1012/
 * @author ly
 *
 */
public class Str1 {
    
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        List<Character> list = new ArrayList<>();
        list.add(s.charAt(0));
        for(int i = 0; i < s.length() - 1 ; i++) {
            for(int j = i+list.size() ; j < s.length() ; j++) {
                char c = s.charAt(j);
                if(list.contains(c)) {
                    max = Math.max(max, list.size());
                    if(list.size() > 1) {
                        list.remove(0);
                    }
                    break;
                }
                list.add(c);
            }
            max = Math.max(max, list.size());
            if(max >= s.length() - i) {
                break;
            }
        }
        max = Math.max(max, list.size());
        return max;
    }
    
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(" "));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
