package com.ly.bytedance;

import java.util.Stack;

/**
 * 
 * https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1011/
 * 翻转字符串里的单词
 * @author ly
 *
 */
public class Str5 {
    
    public static String reverseWords(String s) {
        if(s == null || (s = s.trim()).length() == 0) {
            return "";
        }
        Stack<String> stack = new Stack<>();
        String[] arr = s.split("\\s+");
        for(String str : arr) {
            stack.push(str);
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop())
                .append(" ");
        }
        return builder.substring(0, builder.length() - 1);
     }
    
    public static void main(String[] args) {
        System.out.println(reverseWords(" "));
    }
    
}
