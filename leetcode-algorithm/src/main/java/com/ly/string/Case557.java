package com.ly.string;

public class Case557 {

    public static String reverseWords(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }
        StringBuilder builder = new StringBuilder();
        int nextSpace = s.indexOf(" ");
        int pre = 0;
        while (nextSpace != -1) {
            String cur = s.substring(pre,nextSpace);
            int right = cur.length()-1;
            while (right >= 0) {
                builder.append(cur.charAt(right));
                right--;
            }
            
            while (s.charAt(nextSpace) == ' ') {
                builder.append(' ');
                nextSpace++;
            }
            
            pre = nextSpace;
            nextSpace = s.indexOf(" ", pre);
        }
        if (pre <= s.length() - 1) {
            String cur = s.substring(pre, s.length());
            int right = cur.length()-1;
            while (right >= 0) {
                builder.append(cur.charAt(right));
                right--;
            }
        }
        
        return builder.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
    
}
