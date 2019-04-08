package com.ly.stack;

import java.awt.image.RescaleOp;
import java.util.Stack;

public class Case739 {
    public int[] dailyTemperatures(int[] T) {
        if(T== null) {
            return null;
        }
        int[] ret = new int[T.length];
        
        for(int i = 0 ; i < T.length ; i++) {
            for(int j = i+1 ; j < T.length ; j++) {
                if(T[j] > T[i]) {
                    ret[i] = j - i;
                    break;
                }
            }
        }
        return ret;
    }
    
    public int[] op(int[] T) {
        if (T == null || T.length == 0)
            return T;
        int[] result = new int[T.length];
        int[] stack = new int[T.length]; // 用int数组代替stack
        int top = -1;
        for (int i = 0; i < T.length; i++) {
            while (top > -1 && T[i] > T[stack[top]]) {
                int index = stack[top--];
                result[index] = i - index;
            }
            stack[++top] = i;
        }
        return result;
    }
    
    public int[] dailyTemperatures1(int[] T) {
        if(T== null || T.length == 0) {
            return null;
        }
        
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        for(int i = 1; i < T.length ; i++) {
            while (!stack.isEmpty()) {
                int idx = stack.peek();
                if(T[i] > T[idx]) {
                    res[idx] = i - stack.pop();
                }else {
                    stack.push(i);
                    break;
                }
            }
            if(stack.isEmpty()) {
                stack.push(i);
            }
        }
        return res;
    }
}
