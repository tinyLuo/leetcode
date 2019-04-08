package com.ly.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Case20 {
    
    public static Map<Character, Character> map = new HashMap<>();
    
    static {
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
    }
    
    public static boolean isValid(String s) {
        if(s == null || s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++) {
            Character source = s.charAt(i);
            if(!stack.isEmpty()) {
                Character c = stack.peek();
                if(c.equals(map.get(source))) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(source);
        }
        
        return stack.isEmpty() ? true : false;
    }
    
    
    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }

}
