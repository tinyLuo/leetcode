package com.ly.stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Case150 {
    
    private static Set<String> opSet;
    
    static {
        opSet = new HashSet<>();
        opSet.add("+");
        opSet.add("-");
        opSet.add("*");
        opSet.add("/");
    }
    
    public static int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length < 3) {
            return 0;
        }
        
        Stack<String> stack = new Stack<>();
        for(int i = 0 ; i < tokens.length ; i++) {
            String curStr = tokens[i];
            if(opSet.contains(curStr)) {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                int sum = 0;
                if(curStr.equals("+")) {
                    sum = a+b;
                }else if (curStr.equals("-")) {
                    sum = b - a;
                }else if (curStr.equals("*")) {
                    sum = a * b;
                }else if (curStr.equals("/")) {
                    sum = b / a;
                }
                stack.push(String.valueOf(sum));
            }else {
                stack.push(curStr);
            }
        }
        return Integer.parseInt(stack.pop());
    }
    
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[] {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
        System.out.println(evalRPN(new String[] {"4", "13", "5", "/", "+"}));
    }
}
