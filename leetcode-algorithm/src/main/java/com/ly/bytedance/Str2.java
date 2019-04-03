package com.ly.bytedance;

/**
 * 
 * https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1014/
 * 最长公共前缀
 * @author ly
 *
 */
public class Str2 {
    
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length < 1) {
            return "";
        }
        int len = strs.length;
        int minLen = Integer.MAX_VALUE;
        boolean isCommon = true;
        StringBuilder builder = new StringBuilder();
        char tmp = '1';
        for(int i = 0 ; i < len ; i++) {
            if(strs[i].length() == 0) {
                return "";
            }
            if(i == 0) {
                tmp = strs[i].charAt(0);
            }
            if(tmp != strs[i].charAt(0)) {
                isCommon = false;
                break;
            }
            minLen = Math.min(minLen, strs[i].length());
        }
        if(!isCommon) {
            return "";
        }
        builder.append(tmp);
        for(int i = 1 ; i < minLen ; i++) {
            for(int j = 0 ; j < len ; j++) {
                if(j == 0) {
                    tmp = strs[j].charAt(i);
                }else {
                    if(tmp != strs[j].charAt(i)) {
                        isCommon = false;
                        break;
                    }
                }
            }
            if(!isCommon) {
                break;
            }
            builder.append(tmp);
        }
        return builder.toString();
    }
    
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
    
}
