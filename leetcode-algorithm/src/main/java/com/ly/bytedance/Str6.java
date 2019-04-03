package com.ly.bytedance;

import java.util.Stack;

/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1013/
 * 简化路径
 * @author ly
 *
 */
public class Str6 {
    
    public static String simplifyPath(String path) {
        if(path == null || (path = path.trim()).length() == 0 || !path.startsWith("/")) {
            return "/";
        }
        Stack<String> stack = new Stack<>();
        int left = 0;
        int right = -1;
        while ((right = path.indexOf("/", left+1)) != -1) {
            String subPath = path.substring(left + 1, right);
            if(subPath.length() == 0) {
                left = right;
                continue;
            }
            if(subPath.equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            }else if (subPath.equals(".")) {
                //do nothing
            }else {
                stack.push(subPath);
            }
            left = right;
        }
        
        if(left != path.length() - 1) {
            String subPath = path.substring(left + 1, path.length());
            if(subPath.equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            }else if (subPath.equals(".")) {
                //do nothing
            }else {
                stack.push(subPath);
            }
        }
        
        String s = "";
        while (!stack.isEmpty()) {
            s = "/" + stack.pop() + s;
        }
        if(s.length() == 0) {
            s = "/";
        }
        return s;
    }
    
    
    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifyPath("/a/../../b/../c//.//"));
        System.out.println(simplifyPath("/a//b////c/d//././/.."));
    }
    
}
